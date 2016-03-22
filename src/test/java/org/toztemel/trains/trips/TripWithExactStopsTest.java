package org.toztemel.trains.trips;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.toztemel.trains.TestData;
import org.toztemel.trains.graph.Graph;
import org.toztemel.trains.graph.Town;

public class TripWithExactStopsTest {

	private Trip calculator;
	
	@Before public void
	setup() {
	}

	@Test public void 
	routesOfSingleStop() throws Exception {
		Graph simpleGraph = new TestData().prepare();
		
		calculator = new TripWithExactStops(simpleGraph, 1);
		
		assertEquals (1, calculator.calculate(new Town("A"), new Town("B")));
		assertEquals (1, calculator.calculate(new Town("A"), new Town("D")));
		assertEquals (1, calculator.calculate(new Town("B"), new Town("C")));
		assertEquals (1, calculator.calculate(new Town("C"), new Town("D")));
		assertEquals (1, calculator.calculate(new Town("C"), new Town("E")));
		assertEquals (1, calculator.calculate(new Town("D"), new Town("C")));
		assertEquals (1, calculator.calculate(new Town("D"), new Town("E")));
		assertEquals (1, calculator.calculate(new Town("E"), new Town("B")));
	}
	
	@Test public void 
	routesOfTwoStops() throws Exception {
		Graph simpleGraph = new TestData().prepare();
		
		calculator = new TripWithExactStops(simpleGraph, 2);
		
		assertEquals (2, calculator.calculate(new Town("A"), new Town("C")));
		assertEquals (1, calculator.calculate(new Town("A"), new Town("E")));
		assertEquals (1, calculator.calculate(new Town("A"), new Town("B")));
		assertEquals (1, calculator.calculate(new Town("C"), new Town("B")));
		assertEquals (1, calculator.calculate(new Town("C"), new Town("C")));
	}
	
	@Test public void 
	routesOfThreeStops() throws Exception {
		Graph simpleGraph = new TestData().prepare();
		
		calculator = new TripWithExactStops(simpleGraph, 3);
		
		assertEquals (2, calculator.calculate(new Town("A"), new Town("D")));
	}

	@Test public void 
	routesOfFourStops() throws Exception {
		Graph simpleGraph = new TestData().prepare();
		
		calculator = new TripWithExactStops(simpleGraph, 4);
		
		assertEquals (3, calculator.calculate(new Town("A"), new Town("C")));
	}

}
