package org.toztemel.trains.graph;

import static org.junit.Assert.*;

import org.junit.Test;

public class RouteTest {

	@Test
	public void
	aRouteIsADirectedTrack() {
		Track r = new Route(new Track(3), new Town("A"), new Town("B"));
		
		assertEquals (3, r.length());
	}

	@Test
	public void 
	routeHasVertices() {
		Route r = new Route(new Track(3), new Town("A"), new Town("B"));
		
		assertEquals (new Town("A"), r.source());
		assertEquals (new Town("B"), r.destination());
	}

	@Test
	public void 
	routesOfSameDistanceAndTownsAreEqual() {
		Route aToB = new Route(new Track(3), new Town("A"), new Town("B"));
		Route aToB2 = new Route(new Track(3), new Town("A"), new Town("B"));
		Route bToA = new Route(new Track(3), new Town("B"), new Town("A"));
		Route aToBLong = new Route(new Track(5), new Town("A"), new Town("B"));
		Route cToB = new Route(new Track(3), new Town("C"), new Town("B"));
		Route aToC = new Route(new Track(3), new Town("A"), new Town("C"));
		
		assertEquals(aToB, aToB2);
		assertNotEquals(aToB, bToA);
		assertNotEquals(aToB, aToBLong);
		assertNotEquals(aToB, cToB);
		assertNotEquals(aToB, aToC);
	}

	@Test
	public void 
	emptyRouteHasZeroLength() {
		assertEquals(0, new Route(null, new Town("A"), new Town("B")).length());
	}

	@Test public void 
	routesCanBeAdded() throws Exception {
		Route aToB = new Route(new Track(3), new Town("A"), new Town("B"));
		Route bToC = new Route(new Track(2), new Town("B"), new Town("C"));
		
		assertEquals(new Track(5), aToB.joinWith(bToC));
		assertEquals(new Track(3), aToB);
		assertEquals(new Track(2), bToC);
	}
}
