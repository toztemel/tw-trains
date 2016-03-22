package org.toztemel.trains.input;

import org.toztemel.trains.exception.CannotReadFromInputFileException;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputFileReader {

    private String inputFile;

    public InputFileReader(String inputFile) {
        this.inputFile = inputFile;
    }

    public String read() throws CannotReadFromInputFileException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            return reader.readLine();
        } catch (Exception e) {
            throw new CannotReadFromInputFileException(e, inputFile);
        }
    }


}