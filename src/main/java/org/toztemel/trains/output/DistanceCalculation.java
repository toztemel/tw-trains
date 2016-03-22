package org.toztemel.trains.output;

import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;
import org.toztemel.trains.trips.DistanceCalculator;

public class DistanceCalculation extends Task {

    public DistanceCalculation(Towns graph, Display d, Town... path) {
        this.display = d;
        this.path = path;
        trip = new DistanceCalculator(graph);
    }
}
