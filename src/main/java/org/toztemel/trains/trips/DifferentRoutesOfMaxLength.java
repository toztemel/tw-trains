package org.toztemel.trains.trips;

import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;
import org.toztemel.trains.exception.NoSuchRouteException;

public class DifferentRoutesOfMaxLength implements Trip {

    private Towns towns;
    private int maxLength;
    private Town sourceTown;
    private Town destTown;
    private int count;

    public DifferentRoutesOfMaxLength(Towns towns, int maxLength) {
        this.towns = towns;
        this.maxLength = maxLength;
    }

    @Override
    public int calculate(Town... vertices) throws NoSuchRouteException, NoSuchTownException {
        sourceTown = towns.getTown(vertices[0]);
        destTown = towns.getTown(vertices[1]);
        count = 0;

        initializeDistances(towns);
        traverse(sourceTown, 0);

        return count;
    }

    private void initializeDistances(Towns towns) {
        for (Town town : towns.getTowns()) {
            if (town.equals(sourceTown))
                town.setDistance(0);
            else
                town.setDistance(-1);
        }
    }

    private void traverse(Town town, int distance) throws NoSuchRouteException {
        if (distance >= maxLength)
            return;


        if (town.equals(destTown)) {
            if (distance == 0) {
                // do nothing
            } else if (distance <= maxLength) {
                count++;
            }
        }

        town.setDistance(distance);

        for (Town t : town.allRoutes()) {
            traverse(t, distance + town.getRoute(t).length());
        }

    }
}
