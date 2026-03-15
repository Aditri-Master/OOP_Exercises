package main;
import java.util.HashMap;
import java.util.Map;

public class RallyRaceResult implements RaceResult {

    private String raceName;
    private String location;
    private Map<Driver, Integer> results = new HashMap<>();

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    @Override
    public Map<Driver, Integer> getResults() {
        return results;
    }
}