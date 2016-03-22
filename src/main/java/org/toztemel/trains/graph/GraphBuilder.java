package org.toztemel.trains.graph;

import org.toztemel.trains.exception.NoSuchTownException;

public class GraphBuilder {

    private Graph towns;

    public GraphBuilder(Graph g) {
        towns = g;
    }

    public void addToGraph(String... inputs) throws NoSuchTownException {
        for (String input : inputs) {
            addRoute(input);
        }
    }

    private void addRoute(String input) throws NoSuchTownException {
        String source = input.substring(0, 1);
        String dest = input.substring(1, 2);
        int distance = Integer.parseInt(input.substring(2));

        addToTowns(new Town(source));
        addToTowns(new Town(dest));

        towns.getTown(source).addRoute(towns.getTown(dest), new Track(distance));
    }

    private void addToTowns(Town t) {
        if (!towns.contains(t))
            towns.addTown(t);
    }

}
