package org.toztemel.trains.exception;

import org.junit.Test;
import org.toztemel.trains.graph.Town;

import static org.junit.Assert.*;

public class NoSuchTownExceptionTest {

    @Test public void
    exceptionIncludesName() throws Exception {
        String townName = "ATown";
        NoSuchTownException e = new NoSuchTownException(townName);

        assertTrue(e.getMessage().contains(townName));
    }

    @Test public void
    exceptionIncludesTownName() throws Exception {
        String townName = "ATown";
        Town town = new Town(townName);
        NoSuchTownException e = new NoSuchTownException(town);

        assertTrue(e.getMessage().contains(townName));
    }

}