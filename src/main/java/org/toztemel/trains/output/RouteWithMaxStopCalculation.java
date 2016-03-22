package org.toztemel.trains.output;

import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;
import org.toztemel.trains.trips.TripWithMaxStops;

public class RouteWithMaxStopCalculation extends Task {

    private final int MAX_STOPS = 3;

    public RouteWithMaxStopCalculation(Towns graph, Display d, Town... path) {
        this.display = d;
        this.path = path;

        trip = new TripWithMaxStops(graph, MAX_STOPS);
    }

}
