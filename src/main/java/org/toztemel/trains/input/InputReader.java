package org.toztemel.trains.input;

import org.toztemel.trains.exception.CannotReadFromInputFileException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputReader {

    private static final String DELIMITER = ",";
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";
    List<String> input;

    public InputReader() {
        input = new ArrayList<>();
    }

    public void readFrom(InputFileReader fileReader) throws CannotReadFromInputFileException {
        read(fileReader.read());
    }

    public void read(String inputString) {
        inputString = inputString.replace(SPACE, EMPTY_STRING);
        if (inputString.contains(DELIMITER)) {
            input.addAll(Arrays.asList(inputString.split(DELIMITER)));
        } else {
            input.add(inputString);
        }
    }

    boolean contains(String string) {
        return input.contains(string);
    }

    int size() {
        return input.size();
    }

    public List<String> getInput() {
        return input;
    }

}
