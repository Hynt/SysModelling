/**
 * Created by MarkL on 25.10.2015.
 */
public abstract class Arc {
    Place place;

    public Arc(Place place) {
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

	@Override
	public String toString() {
		return "Arc [place=" + place + "]";
	}
}
