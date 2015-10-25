import java.util.List;

/**
 * @(#) Transition.java
 */
public class Transition
{
    private List<Arc_P_to_T> incomingArcs;
    private List<Arc_T_to_P> outgoingArcs;

    private PetriNet pteriNet;
    
    private Place placeTP;
    
    private Place placePT;
    
    private Event events;
    
    public String getEventLabel( )
    {
        return null;
    }

    public List<Arc_P_to_T> getIncomingArcs() {
        return incomingArcs;
    }

    public List<Arc_T_to_P> getOutgoingArcs() {
        return outgoingArcs;
    }
}
