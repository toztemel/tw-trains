package org.toztemel.trains.trips;

import org.toztemel.trains.exception.NoSuchRouteException;
import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Graph;
import org.toztemel.trains.graph.Town;

public class TripWithExactStops implements Trip {

    private Graph graph;
    private int exactDepth;
    private int totalTripCount;
    private Town sourceTown;
    private Town destinationTown;

    public TripWithExactStops(Graph graph, int depth) {
        this.graph = graph;
        this.exactDepth = depth;
    }

    @Override
    public int calculate(Town... towns) throws NoSuchRouteException, NoSuchTownException {
        totalTripCount = 0;
        sourceTown = graph.getTown(towns[0]);
        destinationTown = graph.getTown(towns[1]);

        traverse(sourceTown, 1);

        return totalTripCount;
    }

    private void traverse(Town town, int depth) {
        if (depthMatches(depth) && routeExists(town)) {
            totalTripCount++;
        }
        if (depthExceeds(depth)) {
            return;
        }
        for (Town nextTown : town.getOutgoingRoutes()) {
            traverse(nextTown, depth + 1);
        }
    }

    private boolean depthExceeds(int depth) {
        return depth >= exactDepth;
    }

    private boolean depthMatches(int depth) {
        return exactDepth == depth;
    }

    private boolean routeExists(Town town) {
        return town.hasRouteTo(destinationTown);
    }

}
