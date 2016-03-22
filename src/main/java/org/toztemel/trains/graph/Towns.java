package org.toztemel.trains.graph;

import org.toztemel.trains.exception.NoSuchTownException;

import java.util.HashSet;
import java.util.Set;

public class Towns {
    Set<Town> graph;

    public Towns() {
        graph = new HashSet<Town>();
    }

    public Towns(Set<Town> towns) {
        this();
        graph.addAll(towns);
    }

    public void addRoute(Town source, Town dest, Track route) {
        if (!graph.contains(source))
            graph.add(source);
        if (!graph.contains(dest))
            graph.add(dest);

        Route dRoute = new Route(route, source, dest);
        source.addRoute(dest, dRoute);
    }

    public void addTown(Town t) {
        graph.add(t);
    }

    public Town getTown(String name) throws NoSuchTownException {
        return getTown(new Town(name));
    }

    public Town getTown(Town town) throws NoSuchTownException {
        for (Town t : graph)
            if (t.equals(town))
                return t;
        throw new NoSuchTownException(town);
    }

    public boolean contains(Town town) {
        return graph.contains(town);
    }

    public int size() {
        return graph.size();
    }

    public Set<Town> getTowns() {
        return graph;
    }

    public void addAllRoutes(Set<Town> towns) {
        graph.addAll(towns);
    }
}
