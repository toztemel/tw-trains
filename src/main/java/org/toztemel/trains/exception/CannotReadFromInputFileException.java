package org.toztemel.trains.exception;

import java.io.FileNotFoundException;

/**
 * Created by tayfuno on 22/03/16.
 */
public class CannotReadFromInputFileException extends FileNotFoundException {

    public CannotReadFromInputFileException(Exception e, String fileName) {
        super("Cannot read input from file " + fileName);
        logProblem(e);
    }

    private void logProblem(Exception e) {
        //e.printStackTrace();
    }
}
