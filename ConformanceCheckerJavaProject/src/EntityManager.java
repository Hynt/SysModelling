import java.util.LinkedList;
import org.deckfour.xes.model.*;
import java.util.Date;
import org.deckfour.xes.extension.std.*;

/**
 * @(#) EntityManager.java
 */
public class EntityManager
{
    public static PetriNet getPetriNet( String petriNetPath )
    {
        return null;
    }
    
    public static EventLog getEventLog( String eventLogPath )
    {
    	
    	LinkedList<Case> cases = new LinkedList<Case>();
    	try {
			XLog log = XLogReader.openLog(eventLogPath);
			for(XTrace parsedCase:log){
				long caseId = Long.parseLong( XConceptExtension.instance().extractName(parsedCase) );
				
				XAttributeMap caseAttributes = parsedCase.getAttributes();
				
				
				LinkedList<Event> events = new LinkedList<Event>();
				for(XEvent event : parsedCase){
					String eventName = XConceptExtension.instance().extractName(event);
					Date timestamp = XTimeExtension.instance().extractTimestamp(event);
					//String eventType = XLifecycleExtension.instance().extractTransition(event);
					
					XAttributeMap eventAttributes = event.getAttributes();
					Event nextEvent = new Event(timestamp, eventName, eventAttributes);
					events.add(nextEvent);
				}
				Trace caseTrace = new Trace( events );
				cases.add( new Case(caseId, caseAttributes, caseTrace) );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return new EventLog(cases);
    }
    
    
}
