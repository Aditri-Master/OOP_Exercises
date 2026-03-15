package main;

import java.util.HashMap;
import java.util.Map;

public class ChampionshipStatistics {

    public static double averagePointsPerDriver(ChampionshipManager manager) {
        int total = 0;

        for (Driver d : manager.getDrivers()) {
            total += d.getPoints();
        }

        return (double) total / manager.getDrivers().size();
    }

    public static String mostSuccessfulCountry(ChampionshipManager manager) {

        Map<String, Integer> countryPoints = new HashMap<>();

        for (Driver d : manager.getDrivers()) {
            countryPoints.put(
                d.getCountry(),
                countryPoints.getOrDefault(d.getCountry(), 0) + d.getPoints()
            );
        }

        String bestCountry = "";
        int max = 0;

        for (String country : countryPoints.keySet()) {
            if (countryPoints.get(country) > max) {
                max = countryPoints.get(country);
                bestCountry = country;
            }
        }

        return bestCountry;
    }

    public static int totalRaces(ChampionshipManager manager) {
        return manager.getRaces().size();
    }
}