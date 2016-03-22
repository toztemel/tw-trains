package org.toztemel.trains.trips;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.toztemel.trains.TestData;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;

public class ShortestTripTest {

	private Trip trip;
	Town a = new Town("A");
	Town b = new Town("B");
	Town c = new Town("C");
	Town d = new Town("D");
	Town e = new Town("E");

	@Before public void
	setup() throws Exception {
		Towns graph = new TestData().prepare();
		trip = new ShortestTrip(graph);
	}
	
	@Test public void 
	shortestTripLengthForAdjacentTowns() throws Exception {
		assertEquals(5, trip.calculate(a, d));
		assertEquals(5, trip.calculate(a, b));
		assertEquals(3, trip.calculate(e, b));
		assertEquals(4, trip.calculate(b, c));
	}
	
	@Test public void 
	shortestTripOfTwoAlternatives() throws Exception {
		assertEquals(5, trip.calculate(a, b));
		assertEquals(7, trip.calculate(a, e));
		assertEquals(2, trip.calculate(c, e));
	}
	
	@Test public void 
	shortestTripLengthOfManyRoutes() throws Exception {
		assertEquals(11, trip.calculate(a, c));
		assertEquals(13, trip.calculate(b, b));
	}

}
