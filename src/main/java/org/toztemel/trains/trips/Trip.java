package org.toztemel.trains.trips;

import org.toztemel.trains.graph.Town;
import org.toztemel.trains.exception.NoSuchRouteException;
import org.toztemel.trains.exception.NoSuchTownException;

public interface Trip {

    public int calculate(Town... towns) throws NoSuchRouteException, NoSuchTownException;
}
