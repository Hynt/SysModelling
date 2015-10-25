import java.util.Date;
import java.util.HashMap;

/**
 * @(#) Event.java
 */
public class Event
{
    private Date timestamp;
    
    private String name;
    
    private HashMap event_attributes;
    
    private Trace traces;
    
    private Transition transitions;
    
    public String getName( )
    {
        return name;
    }
    
    
}
