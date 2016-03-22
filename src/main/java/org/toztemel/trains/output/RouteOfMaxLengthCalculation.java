package org.toztemel.trains.output;

import org.toztemel.trains.graph.Graph;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.trips.DifferentRoutesOfMaxLength;

public class RouteOfMaxLengthCalculation extends Task {

    private static final int MAX_LENGTH = 30;

    public RouteOfMaxLengthCalculation(Graph graph, Display d, Town... path) {
        this.display = d;
        this.path = path;
        trip = new DifferentRoutesOfMaxLength(graph, MAX_LENGTH);
    }

}
