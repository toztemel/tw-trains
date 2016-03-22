package org.toztemel.trains.trips;

import org.toztemel.trains.exception.NoSuchRouteException;
import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;

public class TripWithMaxStops implements Trip {

    private Towns graph;
    private int maxDepth;
    private int totalTripCount;

    public TripWithMaxStops(Towns graph, int depth) {
        this.graph = graph;
        this.maxDepth = depth;
    }

    @Override
    public int calculate(Town... towns) throws NoSuchRouteException, NoSuchTownException {
        totalTripCount = 0;
        Town source = towns[0];
        Town dest = towns[1];
        Town sourceTown = graph.getTown(source.name());
        Town destTown = graph.getTown(dest.name());

        traverse(sourceTown, destTown, 1);

        return totalTripCount;
    }

    private void traverse(Town town, Town dest, int depth) {
        if (town.hasRouteTo(dest)) {
            totalTripCount++;
        }
        if (depth == maxDepth)
            return;

        for (Town t : town.allRoutes()) {
            traverse(t, dest, depth + 1);
        }
    }

}
