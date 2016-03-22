package org.toztemel.trains.graph;

import org.toztemel.trains.exception.NoSuchRouteException;

import java.util.Set;

public class Town {

    private String name;
    private OutgoingRoutes destinations;
    private int distance;

    public Town(String string) {
        name = string;
        destinations = new OutgoingRoutes();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Town) && (((Town) o).name.equals(this.name));
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String name() {
        return name;
    }

    public void addRoute(Town dest, Track route) {
        destinations.addNewRoute(dest, new Route(route, this, dest));
    }

    public boolean hasRouteTo(Town dest) {
        return destinations.containsRouteTo(dest);
    }

    public Track getRoute(Town dest) throws NoSuchRouteException {
        if (destinations.containsRouteTo(dest))
            return destinations.getRoute(dest);
        throw new NoSuchRouteException(this, dest);
    }

    public Set<Town> allRoutes() {
        return destinations.keySet();
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getOwnDistance() {
        return distance;
    }
}
