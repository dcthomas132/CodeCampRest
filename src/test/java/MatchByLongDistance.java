import java.text.ParseException;

public class MatchByLongDistance implements Matchable {
    private long distance;

    public MatchByLongDistance(long distance)
    {
        this.distance = distance;
    }


    @Override
    public boolean match(Planet planet) throws ParseException {
        return (planet.getName().equals(distance));

    }
}
