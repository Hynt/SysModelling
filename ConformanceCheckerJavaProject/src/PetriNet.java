import java.util.List;

/**
 * @(#) PetriNet.java
 */
public class PetriNet
{
    private final List<Place> places;
    private final List<Transition> transitions;

    public PetriNet( List<Transition> transitions, List<Place> places ) {
        this.transitions = transitions;
        this.places = places;
    }

    public List<Place> getPlaces( ) {
        return places;
    }

    public List<Transition> getTransitions( ) {
        return transitions;
    }

    public int numberOfTransitions( )
    {
        return transitions.size();
    }
    public int numberOfPlaces( )
    {
        return places.size();
    }

    public void initialize( )
    {
        for(Place place : places)
        {
            place.removeAllTokens();
            if (place.isStart()){
                place.incrementTokens();
            }
        }
    }
    
    

    public int countEnabledTransitions( )
    {
        int result = 0;
        for (Transition transition : transitions)
        {
            has_zero_tokens:
            {
                for(Place place : transition.getInputPlaces()){
                    if(place.getTokens() == 0){
                        break has_zero_tokens;
                    }
                }
                result++;
            }
        }
        return result;
    }

	@Override
    public String toString( ) {
		return "PetriNet [places=" + places + ", transitions=" + transitions
				+ "]";
	}
    
}
