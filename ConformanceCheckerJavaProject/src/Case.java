import java.util.Map;

/**
 * @(#) Case.java
 */
public class Case
{
    private long ID;
    
    private Map caseAttributes;
    
    private Trace trace;

	
	public Case( long ID, Map caseAttributes, Trace trace ) {
		this.ID = ID;
		this.caseAttributes = caseAttributes;
		this.trace = trace;
	}

	public Trace getTrace( )
    {
        return trace;
    }

	@Override
    public String toString( ) {
		return "Case [ID=" + ID + ", caseAttributes=" + caseAttributes
				+ ", trace=" + trace + "]";
	}
    
    
}
