import java.util.Iterator;
import java.util.List;

/**
 * @(#) EventLog.java
 */
public class EventLog implements Iterable<Case>
{
    private List<Case> cases;

    public EventLog( List<Case> cases ) {
        this.cases = cases;
    }

    public Iterator<Case> iterator( ){
        return cases.iterator();
    }

	@Override
    public String toString( ) {
		return "EventLog [cases=" + cases + "]";
	}
}
