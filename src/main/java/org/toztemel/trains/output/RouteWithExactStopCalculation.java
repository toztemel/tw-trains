package org.toztemel.trains.output;

import org.toztemel.trains.graph.Towns;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.trips.TripWithExactStops;

public class RouteWithExactStopCalculation extends Task {

    private final int EXACT_STOPS = 4;

    public RouteWithExactStopCalculation(Towns graph, Display d, Town... path) {
        this.display = d;
        this.path = path;

        trip = new TripWithExactStops(graph, EXACT_STOPS);
    }

}
