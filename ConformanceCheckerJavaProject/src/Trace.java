import java.util.List;

/**
 * @(#) Trace.java
 */
public class Trace
{
    private int missingTokens;
    
    private int remainingTokens;
    
    private int consumedTokens;
    
    private int producedTokens;
    
    private List<Case> cases; //TODO suunatud assotiation, pole cases listi tarvis
    
    private List<Event> events;
    
    private int numberOfCases;
    
    public Trace(List<Event> events) {
		super();
		this.events = events;
	}

	public float getMeanNumberOfEnabledTransitions( ) {
        return (float)enabledTransitionsCount/events.size();
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

	@Override
	public String toString() {
		return "Trace [missingTokens=" + missingTokens + ", remainingTokens="
				+ remainingTokens + ", consumedTokens=" + consumedTokens
				+ ", producedTokens=" + producedTokens + ", events=" + events
				+ ", numberOfCases=" + numberOfCases
				+ ", enabledTransitionsCount=" + enabledTransitionsCount + "]";
	}
    
}
