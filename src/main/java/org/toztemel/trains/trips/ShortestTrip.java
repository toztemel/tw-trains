package org.toztemel.trains.trips;

import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;
import org.toztemel.trains.exception.NoSuchRouteException;

public class ShortestTrip implements Trip {

    private Towns originalGraph;
    private Town sourceTown;
    private Town destTown;

    public ShortestTrip(Towns graph) {
        this.originalGraph = graph;
    }

    @Override
    public int calculate(Town... towns) throws NoSuchRouteException, NoSuchTownException {
        String sourceName = towns[0].name();
        String destName = towns[1].name();

        Towns tempGraph = new Towns(originalGraph.getTowns());

        sourceTown = tempGraph.getTown(sourceName);
        destTown = tempGraph.getTown(destName);

        initializeDistances(tempGraph);
        traverse(sourceTown, 0);

        return destTown.getOwnDistance();
    }

    private void initializeDistances(Towns towns) {
        for (Town town : towns.getTowns()) {
            if (town.equals(sourceTown))
                town.setDistance(0);
            else
                town.setDistance(Integer.MAX_VALUE);
        }
    }

    private void traverse(Town town, int distance) throws NoSuchRouteException {
        int waitingDuratian = 2;
        if (town.equals(sourceTown) || town.equals(destTown))
            waitingDuratian = 0;

        if (town.getOwnDistance() < distance) {
            if (town.equals(sourceTown) && town.equals(destTown)) {
                town.setDistance(distance);// completed circle
            }
            return;
        }
        town.setDistance(distance);
        for (Town t : town.allRoutes()) {
            traverse(t, town.getOwnDistance() + town.getRoute(t).length() + waitingDuratian);
        }
    }

}
