package org.toztemel.trains.graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrackTest {

	@Test
	public void
	aTrackEncapsulatesADistance() {
		Track r = new Track(3);
		
		assertEquals (3, r.length());
	}

	@Test
	public void 
	tracksOfSameDistanceAreEqual() {
		assertEquals(new Track(3), new Track(3));
		assertNotEquals(new Track(1), new Track(3));
	}

	@Test
	public void 
	emptyTrackHasZeroDistance() {
		assertEquals(0, new Track(null).length());
	}

	@Test public void 
	tracksCanBeAdded() throws Exception {
		Track five = new Track(5);
		Track three = new Track(3);
		
		assertEquals(new Track(8), five.joinWith(three));
		assertEquals(new Track(5), five);
		assertEquals(new Track(3), three);
	}
}
