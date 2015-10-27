import java.util.List;

/**
 * @(#) Transition.java
 */
public class Transition
{

    private final List<Place> inputPlaces;
    private final List<Place> outputPlaces;

    private final String eventLabel;

    public Transition(List<Place> inputPlaces, List<Place> outputPlaces, String eventLabel) {
        this.inputPlaces = inputPlaces;
        this.outputPlaces = outputPlaces;
        this.eventLabel = eventLabel;
    }

    public String getEventLabel( )
    {
        return eventLabel;
    }

    public List<Place> getInputPlaces() {
        return inputPlaces;
    }

    public List<Place> getOutputPlaces() {
        return outputPlaces;
    }

    @Override
    public String toString( ) {
		return "Transition [" +
                    "inputPlaces=" + inputPlaces + "," +
                    "outputPlaces="	+ outputPlaces + ", " +
                    "eventLabel=" + eventLabel +
                "]";
	}

}
