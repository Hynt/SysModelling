import java.util.Iterator;
import java.util.List;

/**
 * @(#) Trace.java
 */
public class Trace implements Iterable<Event>
{
    private int missingTokens;
    
    private int remainingTokens;
    
    private int consumedTokens;
    
    private int producedTokens;
    
    private List<Event> events;
    
    private int numberOfCases;

    private int enabledTransitionsCount;
    
    public Trace( List<Event> events ) {
		this.events = events;
	}

	public float getMeanNumberOfEnabledTransitions( ) {
        return (float)enabledTransitionsCount/events.size();
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
    public String toString( ) {
		return "Trace [missingTokens=" + missingTokens + ", remainingTokens="
				+ remainingTokens + ", consumedTokens=" + consumedTokens
				+ ", producedTokens=" + producedTokens + ", events=" + events
				+ ", numberOfCases=" + numberOfCases
				+ ", enabledTransitionsCount=" + enabledTransitionsCount + "]";
	}

	@Override
	public Iterator<Event> iterator( ) {
		return events.iterator();
	}
    
}
