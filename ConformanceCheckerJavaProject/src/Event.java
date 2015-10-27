import java.util.Map;
import java.util.Date;

/**
 * @(#) Event.java
 */
public class Event implements Comparable<Event>
{
    private Date timestamp;
    
    private String name;
    
    private Map event_attributes;
    
    private Trace traces; //TODO Suunatud assotiation siia
    
    private Transition transitions; //TODO Event-transition assotiation yle vaadata
    
    public Event( Date timestamp, String name, Map event_attributes ) {
		super();
		this.timestamp = timestamp;
		this.name = name;
		this.event_attributes = event_attributes;
	}

	public String getName( )
    {
        return name;
    }

	@Override
    public int compareTo( Event o ) {
		return this.timestamp.compareTo(o.timestamp);
	}

	@Override
    public String toString( ) {
		return "Event [timestamp=" + timestamp + ", name=" + name
				+ ", event_attributes=" + event_attributes + "]";
	}
}
