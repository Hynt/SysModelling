import java.util.Map;

/**
 * @(#) Case.java
 */
public class Case
{
    private long ID;
    
    private Map caseAttributes;
    
    private Trace trace;

	private EventLog eventLog; //TODO Suunatud assotiation siia
    
    public Case(long iD, Map caseAttributes, Trace trace) {
		super();
		ID = iD;
		this.caseAttributes = caseAttributes;
		this.trace = trace;
	}

	public Trace getTrace( )
    {
        return trace;
    }
    
    
}
