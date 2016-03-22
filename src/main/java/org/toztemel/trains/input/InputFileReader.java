package org.toztemel.trains.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputFileReader {

    private static final String CANNOT_READ_CONTENT = "";

    private String inputFile;

    public InputFileReader(String inputFile) {
        this.inputFile = inputFile;

    }

    public String read() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            return reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return CANNOT_READ_CONTENT;
    }

}