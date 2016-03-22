package org.toztemel.trains.input;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InputReaderTest {

    @Test
    public void
    createsAPairAfterReadingOneEntry() {
        InputReader reader = new InputReader();
        reader.read("AB5");

        assertTrue(reader.contains("AB5"));
        assertEquals(1, reader.size());
    }

    @Test
    public void
    createsTwoPairsAfterReadingTwoEntries() {
        InputReader reader = new InputReader();
        reader.read("AB5");
        reader.read("BC4");

        assertTrue(reader.contains("AB5"));
        assertTrue(reader.contains("BC4"));
        assertEquals(2, reader.size());
    }

    @Test
    public void
    createsTwoPairsAfterReadingTwoEntriesAtOnce() {
        InputReader reader = new InputReader();
        reader.read("AB5,BC4");

        assertTrue(reader.contains("AB5"));
        assertTrue(reader.contains("BC4"));
        assertEquals(2, reader.size());
    }

    @Test
    public void
    createsTwoPairsAfterReadingTwoEntriesWithSpaceAtOnce() {
        InputReader reader = new InputReader();
        reader.read("AB5, BC4");

        assertTrue(reader.contains("AB5"));
        assertTrue(reader.contains("BC4"));
        assertEquals(2, reader.size());
    }

    @Test
    public void
    inputsCanBeReadFromInputFileReader() throws Exception {
        String INPUT_TXT = "input2.txt";
        File inputFile = new File(INPUT_TXT);
        inputFile.createNewFile();
        inputFile.deleteOnExit();
        FileWriter writer = new FileWriter(inputFile);
        writer.append("AB5, BC4");
        writer.flush();
        writer.close();


        InputFileReader fileReader = new InputFileReader(INPUT_TXT);
        InputReader reader = new InputReader();
        reader.readFrom(fileReader);

        assertTrue(reader.contains("AB5"));
        assertTrue(reader.contains("BC4"));
        assertEquals(2, reader.size());
    }
}
