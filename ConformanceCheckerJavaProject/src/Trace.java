/**
 * @(#) Trace.java
 */
public class Trace
{
    private int missingTokens;
    
    private int remainingTokens;
    
    private int consumedTokens;
    
    private int producedTokens;
    
    private Case cases;
    
    private Event[] events;
    
    private int numberOfCases;

    public float getMeanNumberOfEnabledTransitions( ) {
        return (float)enabledTransitionsCount/events.length;
    }

    private int enabledTransitionsCount;

    public Event getNextEvent( )
    {
        return null;
    }
    
    public void incrementMissingTokens( )
    {
        missingTokens++;
    }
    
    public void incrementCaseCount( )
    {
        numberOfCases++;
    }
    
    public void incrementConsumedTokens( )
    {
        consumedTokens++;
    }
    
    public void incrementProducedTokens( )
    {
        producedTokens++;
    }
    
    public void incrementRemainingTokens( )
    {
        remainingTokens++;
    }
    
    public void decrementRemainingTokens( )
    {
        remainingTokens--;
    }
    

    public void addToEnabledTransitionsSum( int enabledTransitionsCount )
    {
        this.enabledTransitionsCount += enabledTransitionsCount;
    }

    public int getMissingTokens( ) {
        return missingTokens;
    }

    public int getRemainingTokens( ) {
        return remainingTokens;
    }

    public int getConsumedTokens( ) {
        return consumedTokens;
    }

    public int getProducedTokens( ) {
        return producedTokens;
    }

    public int getNumberOfCases( ) {
        return numberOfCases;
    }
}
