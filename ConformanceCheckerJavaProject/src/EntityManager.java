import java.util.LinkedList;
import java.io.InputStream;
import org.deckfour.xes.model.*;
import org.processmining.models.semantics.petrinet.Marking;
import java.util.List;
import java.util.Collections;
import java.util.Date;
import org.processmining.models.graphbased.directed.petrinet.impl.PetrinetFactory;
import org.processmining.models.connections.GraphLayoutConnection;
import org.processmining.models.graphbased.directed.petrinet.PetrinetGraph;

import java.io.File;
import org.processmining.plugins.pnml.Pnml;
import java.util.Collection;
import org.deckfour.xes.extension.std.*;
import java.io.FileInputStream;
import java.util.stream.Collectors;


/**
 * @(#) EntityManager.java
 */
public class EntityManager
{
    public static PetriNet getPetriNet( String petriNetPath )
    {
    	
    	LinkedList<Place> places = new LinkedList<>();
    	LinkedList<Transition> transitions = new LinkedList<>();
    	
    	PnmlImportUtils ut = new PnmlImportUtils();
		File f = new File (petriNetPath);
		try {
			// Read and parse the whole PetriNet
			InputStream input = new FileInputStream(f);
			Pnml pnml = ut.importPnmlFromStream(input, f.getName(), f.length());
			PetrinetGraph net = PetrinetFactory.newInhibitorNet(pnml.getLabel() + " (imported from " + f.getName() + ")");
			Marking marking = new Marking();
			pnml.convertToNet(net,marking ,new GraphLayoutConnection(net));
			Collection<org.processmining.models.graphbased.directed.petrinet.elements.Place> pmPlaces = net.getPlaces();
			Collection<org.processmining.models.graphbased.directed.petrinet.elements.Transition> pmTransitions = net.getTransitions();
			
			// Parse places
			places.addAll(pmPlaces.stream().map(pmPlace -> new Place(pmPlace.getLabel())).collect(Collectors.toList()));
			for (org.processmining.models.graphbased.directed.petrinet.elements.Transition pmTransition : pmTransitions) {
				
				// Parse arcs for transitions
				LinkedList<Place> inputPlaces = net.getInEdges(pmTransition).stream().map(pmArc -> findPlaceByLabel(places, pmArc.getSource().getLabel())).collect(Collectors.toCollection(() -> new LinkedList<>()));

				LinkedList<Place> outputPlaces = net.getOutEdges(pmTransition).stream().map(pmArc -> findPlaceByLabel(places, pmArc.getTarget().getLabel())).collect(Collectors.toCollection(() -> new LinkedList<>()));

				// New transitions with the parsed arcs
				transitions.add( new Transition( inputPlaces, outputPlaces, pmTransition.getLabel()) );
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
    	
        return new PetriNet(transitions, places);
    }
    
    public static EventLog getEventLog( String eventLogPath )
    {
    	
    	LinkedList<Case> cases = new LinkedList<>();
    	try {
			XLog log = XLogReader.openLog(eventLogPath);
			for(XTrace parsedCase:log){
				long caseId = Long.parseLong( XConceptExtension.instance().extractName(parsedCase) );
				
				XAttributeMap caseAttributes = parsedCase.getAttributes();
				
				LinkedList<Event> events = new LinkedList<>();
				for(XEvent event : parsedCase){
					String eventName = XConceptExtension.instance().extractName(event);
					Date timestamp = XTimeExtension.instance().extractTimestamp(event);
					//String eventType = XLifecycleExtension.instance().extractTransition(event);
					
					XAttributeMap eventAttributes = event.getAttributes();
					Event nextEvent = new Event(timestamp, eventName, eventAttributes);
					events.add(nextEvent);
				}
				Collections.sort(events);
				Trace caseTrace = new Trace( events );
				cases.add( new Case(caseId, caseAttributes, caseTrace) );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return new EventLog(cases);
    }
    
    private static Place findPlaceByLabel( List<Place> places, String label )
    {
		for (Place element : places) {
			if (element.getName().equals(label)) return element;
		}
    	return null;
    }
    
}
