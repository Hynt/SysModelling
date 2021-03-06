import java.util.Map;
import java.util.Date;

/**
 * @(#) Event.java
 */
public class Event implements Comparable<Event>
{
    private final Date timestamp;
    
    private final String name;
    
    private final Map event_attributes;
    
    

public Event( Date timestamp, String name, Map event_attributes ) {
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
