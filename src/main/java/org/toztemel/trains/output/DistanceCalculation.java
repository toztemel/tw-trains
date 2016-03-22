package org.toztemel.trains.output;

import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Graph;
import org.toztemel.trains.trips.DistanceCalculator;

public class DistanceCalculation extends Task {

    public DistanceCalculation(Graph graph, Display d, Town... path) {
        this.display = d;
        this.path = path;
        trip = new DistanceCalculator(graph);
    }
}
