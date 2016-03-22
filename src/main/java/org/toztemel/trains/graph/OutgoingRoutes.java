package org.toztemel.trains.graph;

import java.util.HashMap;

public class OutgoingRoutes extends HashMap<Town, Route> {

    private static final long serialVersionUID = -8251905959784426454L;

    public OutgoingRoutes() {

    }

    public void addNewRoute(Town dest, Route route) {
        put(dest, route);
    }

    public boolean containsRouteTo(Town dest) {
        return containsKey(dest);
    }

    public Track getRoute(Town dest) {
        return get(dest);
    }
}
