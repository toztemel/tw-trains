package org.toztemel.trains.graph;

import static org.junit.Assert.*;

import org.junit.Test;
import org.toztemel.trains.exception.NoSuchRouteException;

public class TownTest {

	@Test
	public void 
	hashCodeIsTownNameHash() {
		String name = "A";
		Town town = new Town(name);
		assertEquals(name.hashCode(), town.hashCode());
	}

	@Test
	public void 
	twoTownsOfTheSameNameAreEqual() {
		assertEquals(new Town("A"), new Town("A"));
		assertNotEquals(new Town("A"),"A");
	}
	
	@Test
	public void 
	twoDifferentTownsAreNotEqual() {
		assertNotEquals(new Town("a"), new Town("A"));
	}

	@Test
	public void 
	townsAreLinkedIfRouteIsAdded() {
		Town source = new Town("A");
		Town dest = new Town ("B");
		
		assertFalse(source.hasRouteTo(dest));
		
		source.addRoute(dest, new Track(0));
		
		assertTrue(source.hasRouteTo(dest));
	}
	
	@Test
	public void 
	routesBetweenTownsAreDirected() {
		Town t1 = new Town("A");
		Town t2 = new Town ("B");
		Town t3 = new Town ("C");

		Track route = new Track(0);
		t1.addRoute(t2, route);
		t1.addRoute(t3, route);
		t2.addRoute(t3, route);

		assertTrue(t1.hasRouteTo(t2));
		assertTrue(t1.hasRouteTo(t3));
		assertTrue(t2.hasRouteTo(t3));
		assertFalse(t2.hasRouteTo(t1));
		assertFalse(t3.hasRouteTo(t1));
		assertFalse(t3.hasRouteTo(t2));
	}

	@Test
	public void 
	routesBetweenTownsAreWeighted() throws Exception {
		Town t1 = new Town("A");
		Town t2 = new Town ("B");
		Town t3 = new Town ("C");

		t1.addRoute(t2, new Track(2));
		t2.addRoute(t1, new Track(1));
		t1.addRoute(t3, new Track(3));
		t2.addRoute(t3, new Track(4));

		assertEquals(new Track(2), t1.getRoute(t2));
		assertEquals(new Track(1), t2.getRoute(t1));
		assertEquals(new Track(3), t1.getRoute(t3));
		assertEquals(new Track(4), t2.getRoute(t3));
	}
	
	@Test(expected=NoSuchRouteException.class)
	public void 
	throwsExceptionIfNoRoutes() throws Exception {
		Town t1 = new Town("A");
		Town t2 = new Town ("B");
		Town t3 = new Town ("C");

		t1.addRoute(t2, new Track(2));
		t2.addRoute(t1, new Track(1));
		t1.addRoute(t3, new Track(3));
		t2.addRoute(t3, new Track(4));
		
		t3.getRoute(t1);
		fail("Should throw exception when route is not found");
	}

}
