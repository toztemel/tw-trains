package org.toztemel.trains.input;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.toztemel.trains.exception.CannotReadFromInputFileException;

public class InputFileReaderTest {

	private static final String INPUT_TXT = "input.txt";
	
	File inputFile;
	private FileWriter writer;

	@Before public void 
	setUp() throws Exception {
		inputFile = new File(INPUT_TXT);
		inputFile.createNewFile();
		inputFile.deleteOnExit();
		
		writer = new FileWriter(inputFile);
	}
	
	@After public void
	tearDown() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeToInputFile(String input) throws IOException {
		writer.append(input);
		writer.flush();
		writer.close();
	}

	@Test(expected = CannotReadFromInputFileException.class) public void
	givenUnknownFileThrowsException() throws IOException {
		String NON_EXISTENT_FILE = "nosuchfile.txt";
		InputFileReader reader = new InputFileReader(NON_EXISTENT_FILE);
		reader.read();
	}


	@Test public void
	givenFileReadsInput() throws IOException {
		String Test_Content = "AB5, BC4";
		writeToInputFile(Test_Content);

		InputFileReader reader = new InputFileReader(INPUT_TXT);
		assertEquals(Test_Content, reader.read());
	}

}
