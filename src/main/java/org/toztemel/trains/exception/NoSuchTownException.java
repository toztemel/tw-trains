package org.toztemel.trains.exception;

import org.toztemel.trains.graph.Town;

public class NoSuchTownException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 2569074465843662054L;

    public NoSuchTownException(String name) {
        super("No town found as " + name);
    }

    public NoSuchTownException(Town town) {
        super("No town found as " + town.name());
    }

}
