package main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChampionshipManager {

    private static ChampionshipManager instance;

    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addRaceResult(RallyRaceResult race) {
        races.add(race);
    }

    public List<Driver> getStandings() {
        drivers.sort(Comparator.comparingInt(Driver::getPoints).reversed());
        return drivers;
    }

    public Driver getLeader() {
        return getStandings().get(0);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<RallyRaceResult> getRaces() {
        return races;
    }
}