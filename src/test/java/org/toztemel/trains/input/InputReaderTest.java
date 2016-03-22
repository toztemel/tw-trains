package org.toztemel.trains.input;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputReaderTest {

	@Test public void 
	createsAPairAfterReadingOneEntry() {
		InputReader reader = new InputReader();
		reader.read("AB5");
		
		assertTrue(reader.contains("AB5"));
		assertEquals(1, reader.size());
	}

	@Test public void 
	createsTwoPairsAfterReadingTwoEntries() {
		InputReader reader = new InputReader();
		reader.read("AB5");
		reader.read("BC4");
		
		assertTrue(reader.contains("AB5"));
		assertTrue(reader.contains("BC4"));
		assertEquals(2, reader.size());
	}

	@Test public void 
	createsTwoPairsAfterReadingTwoEntriesAtOnce() {
		InputReader reader = new InputReader();
		reader.read("AB5,BC4");
		
		assertTrue(reader.contains("AB5"));
		assertTrue(reader.contains("BC4"));
		assertEquals(2, reader.size());
	}
	
	@Test public void 
	createsTwoPairsAfterReadingTwoEntriesWithSpaceAtOnce() {
		InputReader reader = new InputReader();
		reader.read("AB5, BC4");

		assertTrue(reader.contains("AB5"));
		assertTrue(reader.contains("BC4"));
		assertEquals(2, reader.size());
	}

}
