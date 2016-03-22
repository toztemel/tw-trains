package org.toztemel.trains.trips;

import org.toztemel.trains.exception.NoSuchRouteException;
import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Graph;
import org.toztemel.trains.graph.Town;

public class DifferentRoutesOfMaxLength implements Trip {

    private Graph towns;
    private Town sourceTown;
    private Town destTown;
    private int maxLength;
    private int count;

    public DifferentRoutesOfMaxLength(Graph towns, int maxLength) {
        this.towns = towns;
        this.maxLength = maxLength;
    }

    @Override
    public int calculate(Town... vertices) throws NoSuchRouteException, NoSuchTownException {
        sourceTown = towns.getTown(vertices[0]);
        destTown = towns.getTown(vertices[1]);
        count = 0;

        resetDistances(towns);
        traverse(sourceTown, 0);

        return count;
    }

    private void resetDistances(Graph towns) {
        for (Town town : towns.getTowns()) {
            resetDistance(town);
        }
    }

    private void resetDistance(Town town) {
        if (town.equals(sourceTown))
            town.setDistance(0);
        else
            town.setDistance(-1);
    }

    private void traverse(Town town, int distance) throws NoSuchRouteException {
        if (distance >= maxLength)
            return;

        if (arrivedDestination(town) && validDistance(distance)) {
            count++;
        }

        town.setDistance(distance);

        for (Town t : town.getOutgoingRoutes()) {
            int newDistance = distance + town.getRoute(t).length();
            traverse(t, newDistance);
        }

    }

    private boolean validDistance(int distance) {
        return distance != 0 && distance <= maxLength;
    }

    private boolean arrivedDestination(Town town) {
        return town.equals(destTown);
    }
}
