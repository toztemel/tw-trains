package org.toztemel.trains.trips;

import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Graph;
import org.toztemel.trains.exception.NoSuchRouteException;

public class ShortestTrip implements Trip {

    private Graph originalGraph;
    private Town sourceTown;
    private Town destTown;

    public ShortestTrip(Graph graph) {
        this.originalGraph = graph;
    }

    @Override
    public int calculate(Town... towns) throws NoSuchRouteException, NoSuchTownException {
        Graph tempGraph = new Graph(originalGraph.getTowns());

        sourceTown = tempGraph.getTown(towns[0]);
        destTown = tempGraph.getTown(towns[1]);
        resetDistances(tempGraph);
        traverse(sourceTown, 0);

        return destTown.getOwnDistance();
    }

    private void resetDistances(Graph towns) {
        for (Town town : towns.getTowns()) {
            if (town.equals(sourceTown))
                town.setDistance(0);
            else
                town.setDistance(Integer.MAX_VALUE);
        }
    }

    private void traverse(Town town, int distance) throws NoSuchRouteException {
        int waitingDuration = 2;

        if (town.equals(sourceTown) || town.equals(destTown))
            waitingDuration = 0;

        if (town.getOwnDistance() < distance) {
            if (town.equals(sourceTown) && town.equals(destTown)) {
                town.setDistance(distance);// completed circle
            }
            return;
        }
        town.setDistance(distance);
        for (Town t : town.getOutgoingRoutes()) {
            int newDistance = town.getOwnDistance() + town.getRoute(t).length() + waitingDuration;
            traverse(t, newDistance);
        }
    }

}
