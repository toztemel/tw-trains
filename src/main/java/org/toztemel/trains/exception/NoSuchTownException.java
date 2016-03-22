package org.toztemel.trains.exception;

import org.toztemel.trains.graph.Town;

public class NoSuchTownException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 2569074465843662054L;
    private static final String MSG = "No such town as ";

    public NoSuchTownException(String name) {
        super(MSG + name);
    }

    public NoSuchTownException(Town town) {
        super(MSG + town.name());
    }

}
