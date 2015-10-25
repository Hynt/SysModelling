/**
 * Created by MarkL on 25.10.2015.
 */
public abstract class Arc {
    Place place;
    Transition transition;

    public Arc(Place place, Transition transition) {
        this.place = place;
        this.transition = transition;
    }

    public Place getPlace() {
        return place;
    }
}
