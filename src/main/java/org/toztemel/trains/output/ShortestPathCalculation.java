package org.toztemel.trains.output;

import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Graph;
import org.toztemel.trains.trips.ShortestTrip;

public class ShortestPathCalculation extends Task {

    public ShortestPathCalculation(Graph graph, Display d, Town... path) {
        this.display = d;
        this.path = path;

        trip = new ShortestTrip(graph);
    }

}
