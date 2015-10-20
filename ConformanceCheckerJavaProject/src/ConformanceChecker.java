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
        eventLog = null;
        //parse petrinet
        petriNet = null;
        //Process all cases extracting unique trace
        Trace[] traces = null;
        //SIIIAA TULEB TÖÖÖ

        return new Metrics(
                calculateFitness(traces),
                calculateSBA(traces),
                calculateSSA()
        );
    }
    
    public float calculateFitness(Trace[] traces)
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

    public float calculateSBA(Trace[] traces)
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

    public float calculateSSA()
    {
        return
            (float)(petriNet.numberOfTransitions() + 2)
            /
            (petriNet.numberOfPlaces() + petriNet.numberOfTransitions());
    }
    
    
}
