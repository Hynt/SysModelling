/**
 * @(#) PetriNet.java
 */
public class PetriNet
{
    private Place[] places;
    
    private Transition[] transitions;

    public int numberOfTransitions( )
    {
        return transitions.length;
    }
    public int numberOfPlaces( )
    {
        return places.length;
    }
    public Transition getNextTransition( )
    {
        return null;
    }
    
    public void initialize( )
    {
        
    }
    
    public Place getNextPlace( )
    {
        return null;
    }
    
    

    public int countEnabledTransitions( )
    {
        return 0;
    }
    
    
}
