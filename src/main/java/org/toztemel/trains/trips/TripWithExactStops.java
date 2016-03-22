package org.toztemel.trains.trips;

import org.toztemel.trains.exception.NoSuchRouteException;
import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;

public class TripWithExactStops implements Trip {

    private Towns graph;
    private int exactDepth;
    private int totalTripCount;
    private Town sourceTown;
    private Town destTown;

    public TripWithExactStops(Towns graph, int depth) {
        this.graph = graph;
        this.exactDepth = depth;
    }

    @Override
    public int calculate(Town... towns) throws NoSuchRouteException, NoSuchTownException {
        totalTripCount = 0;
        Town source = towns[0];
        Town dest = towns[1];
        sourceTown = graph.getTown(source.name());
        destTown = graph.getTown(dest.name());

        traverse(sourceTown, destTown, 1);

        return totalTripCount;
    }

    private void traverse(Town town, Town dest, int depth) {
        if (town.hasRouteTo(dest) && exactDepth == depth) {
            totalTripCount++;
        }
        if (depth >= exactDepth)
            return;

        for (Town t : town.allRoutes()) {
            traverse(t, dest, depth + 1);
        }
    }

}
