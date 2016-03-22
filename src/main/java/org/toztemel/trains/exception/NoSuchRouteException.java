package org.toztemel.trains.exception;

import org.toztemel.trains.graph.Town;

public class NoSuchRouteException extends Exception {

    private static final long serialVersionUID = 2028632347123891889L;

    public NoSuchRouteException(Town source, Town dest) {
        super("No route found between " + source.name() + " and " + dest.name());
    }
}
