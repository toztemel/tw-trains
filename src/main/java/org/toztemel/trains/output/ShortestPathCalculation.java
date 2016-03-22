package org.toztemel.trains.output;

import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;
import org.toztemel.trains.trips.ShortestTrip;

public class ShortestPathCalculation extends Task {

    public ShortestPathCalculation(Towns graph, Display d, Town... path) {
        this.display = d;
        this.path = path;

        trip = new ShortestTrip(graph);
    }

}
