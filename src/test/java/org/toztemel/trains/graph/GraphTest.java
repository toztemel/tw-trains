package org.toztemel.trains.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	Towns graph;

	@Before
	public void 
	setup() {
		graph = new Towns();
	}

	@Test public void 
	containsTwoTownsGivenAnEntry() throws Exception {
		Track distance = null;
		graph.addRoute(new Town("A"), new Town("B"), distance);

		assertTrue(graph.contains(new Town("A")));
		assertTrue(graph.contains(new Town("B")));
		assertTrue(graph.size() == 2);
		assertEquals(new Town("A"), graph.getTown("A"));
		assertEquals(new Town("B"), graph.getTown("B"));
	}

	@Test public void 
	containsThreeTownsGivenTwoEntries() throws Exception {
		Track distance = null;

		graph.addRoute(new Town("A"), new Town("B"), distance);
		graph.addRoute(new Town("B"), new Town("C"), distance);

		assertTrue(graph.contains(new Town("A")));
		assertTrue(graph.contains(new Town("B")));
		assertTrue(graph.contains(new Town("C")));
		assertFalse(graph.contains(new Town("D")));
		assertTrue(graph.size() == 3);
		assertEquals(new Town("A"), graph.getTown("A"));
		assertEquals(new Town("B"), graph.getTown("B"));
		assertEquals(new Town("C"), graph.getTown("C"));
	}
	
	@Test public void 
	containsThreeTownsGivenThreeEntries() throws Exception {
		Track distance = null;

		graph.addRoute(new Town("A"), new Town("B"), distance);
		graph.addRoute(new Town("B"), new Town("C"), distance);
		graph.addRoute(new Town("C"), new Town("A"), distance);

		assertTrue(graph.contains(new Town("A")));
		assertTrue(graph.contains(new Town("B")));
		assertTrue(graph.contains(new Town("C")));
		assertFalse(graph.contains(new Town("D")));
		assertTrue(graph.size() == 3);
		assertEquals(new Town("A"), graph.getTown("A"));
		assertEquals(new Town("B"), graph.getTown("B"));
		assertEquals(new Town("C"), graph.getTown("C"));
	}

}
