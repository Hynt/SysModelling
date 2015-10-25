import java.util.Date;
import java.util.Map;

/**
 * @(#) Event.java
 */
public class Event
{
    private Date timestamp;
    
    private String name;
    
    private Map event_attributes;
    
    private Trace traces; //TODO Suunatud assotiation siia
    
    private Transition transitions; //TODO Event-transition assotiation yle vaadata
    
    public Event(Date timestamp, String name, Map event_attributes) {
		super();
		this.timestamp = timestamp;
		this.name = name;
		this.event_attributes = event_attributes;
	}

	public String getName( )
    {
        return name;
    }
    
    
}
