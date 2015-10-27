import java.util.Iterator;
import java.util.List;
import java.util.HashMap;

/**
 * @(#) ConformanceChecker.java
 */
public class ConformanceChecker
{
    
private EventLog eventLog;
    
    private PetriNet petriNet;
    
    public Metrics getMetrics( String eventLogPath, String petriNetPath )
    {
        //Parse eventlog
        eventLog = EntityManager.getEventLog(eventLogPath);
        //parse petrinet
        petriNet = EntityManager.getPetriNet(petriNetPath);
        //Process all cases extracting unique trace
        createTraceSet(eventLog);
        Trace[] traces = createTraceSet(eventLog);

        for (Trace trace : traces) {
        	petriNet.initialize();
        	Transition transition;

            for (Event event : trace) {
                trace.addToEnabledTransitionsSum(petriNet.countEnabledTransitions());

                event.getName();
                List<Transition> transitions = petriNet.getTransitions();
                int i = 0;
                while (true) {
                    transition = transitions.get(i);
                    if (transition.getEventLabel().equals(event.getName())) {
                        break;
                    }
                    i++;
                }
                transition.fire();
                //TODO the fire stuff
            }
        	trace.addToEnabledTransitionsSum(petriNet.countEnabledTransitions());
        }

        return new Metrics(
                calculateFitness(traces),
                calculateSBA(traces),
                calculateSSA()
        );
    }
    
    private float calculateFitness( Trace[] traces )
    {

        int a = 0, b = 0, c = 0, d = 0;
        for (Trace trace : traces)
        {
            int n = trace.getNumberOfCases();
            a += n * trace.getMissingTokens();
            b += n * trace.getConsumedTokens();
            c += n * trace.getRemainingTokens();
            d += n * trace.getProducedTokens();
        }

        return 1 - ((float)a/b+(float)c/d)/2;
    }

    private float calculateSBA( Trace[] traces )
    {
        int tv = petriNet.numberOfTransitions();

        float sum1 = 0;
        int sum2 = 0;
        for (Trace trace : traces) {
            int n = trace.getNumberOfCases();
            float x = trace.getMeanNumberOfEnabledTransitions();
            sum1 += n*(tv-x);
            sum2 += n;
        }
        return sum1 / ((tv-1)*sum2);
    }

    private float calculateSSA( )
    {
        return
            (float)(petriNet.numberOfTransitions() + 2)
            /
            (petriNet.numberOfPlaces() + petriNet.numberOfTransitions());
    }
    
    private Trace[] createTraceSet( EventLog eventLog )
    {
    	HashMap<String, Trace> traces = new HashMap<String, Trace>();
    	
    	Iterator<Case> caseIter = eventLog.iterator();
    	while (caseIter.hasNext()) {
    		Case nextCase = caseIter.next();
    		Trace trace = nextCase.getTrace();
    		
    		String s = "";
    		Iterator<Event> eventIter = trace.iterator();
    		while (eventIter.hasNext()) {
    			Event event = eventIter.next();
    			s = s.concat(event.getName());
    		}
    		
    		traces.get(s).incrementCaseCount();
    		if (!traces.containsKey(s)) {
    			traces.put(s, trace);
    		}
    	}
    	Trace[] out = {}; 
		return traces.values().toArray(out);
    }
}

