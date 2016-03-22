package org.toztemel.trains.input;

import java.io.BufferedReader;
import java.io.FileReader;

public class InputFileReader {

    private static final String CANNOT_READ_CONTENT = "";

    private String inputFile;

    public InputFileReader(String inputFile) {
        this.inputFile = inputFile;
    }

    public String read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            return reader.readLine();
        } catch (Exception e) {
            logError(e);
        }
        return CANNOT_READ_CONTENT;
    }

    private void logError(Exception e) {
        e.printStackTrace();
    }

}