import java.text.ParseException;

public class CheckIfDistanceIsLarger implements Matchable{
    private long distance;

    public CheckIfDistanceIsLarger(long distance){
        this.distance = distance;
    }

    @Override
    public boolean match(Planet planet) throws ParseException {

        return (distance > planet.getDistance());

    }
}
