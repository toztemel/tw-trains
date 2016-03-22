package org.toztemel.trains.output;

import org.toztemel.trains.graph.Towns;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.trips.DifferentRoutesOfMaxLength;

public class RouteOfMaxLengthCalculation extends Task {

    private static final int MAX_LENGTH = 30;

    public RouteOfMaxLengthCalculation(Towns graph, Display d, Town... path) {
        this.display = d;
        this.path = path;

        trip = new DifferentRoutesOfMaxLength(graph, MAX_LENGTH);
    }

}
