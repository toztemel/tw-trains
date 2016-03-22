package org.toztemel.trains.graph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GraphBuilderTest {

	private GraphBuilder builder;
	private Towns towns;

	@Before
	public void 
	setup() {
		towns = new Towns();
		builder = new GraphBuilder(towns);
	}

	@Test
	public void 
	containsTwoTownsGivenAnEntry() throws Exception {
		builder.addToGraph("AB0");

		assertTrue(towns.contains(new Town("A")));
		assertTrue(towns.contains(new Town("B")));
		assertFalse(towns.contains(new Town("C")));
		assertTrue(towns.size() == 2);
	}

	@Test
	public void 
	containsThreeTownsGivenTwoEntries() throws Exception {
		builder.addToGraph("AB0");
		builder.addToGraph("BC0");

		assertTrue(towns.contains(new Town("A")));
		assertTrue(towns.contains(new Town("B")));
		assertTrue(towns.contains(new Town("C")));
		assertTrue(towns.size() == 3);
	}

	@Test
	public void 
	containsARouteGivenAnEntry() throws Exception {
		builder.addToGraph("AB1");
		
		Town source = towns.getTown("A");
		
		assertTrue(source.hasRouteTo(new Town("B")));
		assertFalse(source.hasRouteTo(new Town("C")));
	}

	@Test
	public void 
	containsRoutesGivenEntries() throws Exception {
		builder.addToGraph("AB1");
		builder.addToGraph("BC30");
		builder.addToGraph("AC200");
		
		Town townA = towns.getTown("A");
		Town townB = towns.getTown("B");
		Town townC = towns.getTown("C");
		
		assertTrue(townA.hasRouteTo(new Town("B")));
		assertTrue(townA.hasRouteTo(new Town("C")));
		assertTrue(townB.hasRouteTo(new Town("C")));
		assertFalse(townB.hasRouteTo(new Town("A")));
		assertFalse(townC.hasRouteTo(new Town("B")));
		assertFalse(townC.hasRouteTo(new Town("A")));
		
		assertEquals(new Track(1) , townA.getRoute(townB));
		assertEquals(new Track(200) , townA.getRoute(townC));
		assertEquals(new Track(30) , townB.getRoute(townC));
	}
	
}
