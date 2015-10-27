import java.util.List;

/**
 * @(#) Transition.java
 */
public class Transition
{
    private List<Arc_P_to_T> incomingArcs;
    private List<Arc_T_to_P> outgoingArcs;

    //TODO Remove me
    private PetriNet pteriNet;
    
    private Place placeTP;
    
    private Place placePT;
    
    private String eventLabel;
    
    public Transition( List<Arc_P_to_T> incomingArcs,
			List<Arc_T_to_P> outgoingArcs, String eventLabel ) {
		this.incomingArcs = incomingArcs;
		this.outgoingArcs = outgoingArcs;
		this.eventLabel = eventLabel;
	}

	public String getEventLabel( )
    {
        return null;
    }

    public List<Arc_P_to_T> getIncomingArcs( ) {
        return incomingArcs;
    }

    public List<Arc_T_to_P> getOutgoingArcs( ) {
        return outgoingArcs;
    }

	@Override
    public String toString( ) {
		return "Transition [incomingArcs=" + incomingArcs + ", outgoingArcs="
				+ outgoingArcs + ", eventLabel=" + eventLabel + "]";
	}
    
}
