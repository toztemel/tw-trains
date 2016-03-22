package org.toztemel.trains.trips;

import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;
import org.toztemel.trains.exception.NoSuchRouteException;
import org.toztemel.trains.graph.Track;

public class DistanceCalculator implements Trip {

    private Towns graph;

    public DistanceCalculator(Towns graph) {
        this.graph = graph;
    }

    @Override
    public int calculate(Town... towns) throws NoSuchRouteException, NoSuchTownException {
        int distance = 0;
        int waitingDuration = 2;

        for (int i = 0; i < towns.length - 1; i++) {
            Town source = towns[i];
            Town dest = towns[i + 1];
            String name = source.name();
            Town town = graph.getTown(name);
            Track route = town.getRoute(dest);
            distance += route.length();
            distance += waitingDuration;
        }
        distance -= waitingDuration;
        return distance;
    }

}
