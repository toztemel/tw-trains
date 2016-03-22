package org.toztemel.trains.trips;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.toztemel.trains.TestData;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;

public class TripWithMaxStopsTest {

	private Trip calculator;
	
	@Before public void
	setup() {
	}
	
	@Test public void 
	routesOfSingleStop() throws Exception {
		Towns towns = new TestData().prepare();
	
		calculator = new TripWithMaxStops(towns, 1);
		
		assertEquals (0, calculator.calculate(new Town("E"), new Town("A")));
		assertEquals (1, calculator.calculate(new Town("A"), new Town("B")));
		assertEquals (1, calculator.calculate(new Town("A"), new Town("D")));
		assertEquals (1, calculator.calculate(new Town("B"), new Town("C")));
		assertEquals (1, calculator.calculate(new Town("C"), new Town("D")));
		assertEquals (1, calculator.calculate(new Town("C"), new Town("E")));
		assertEquals (1, calculator.calculate(new Town("D"), new Town("C")));
		assertEquals (1, calculator.calculate(new Town("D"), new Town("E")));
	}
	
	@Test public void 
	routesOfMaxTwoStops() throws Exception {
		Towns towns = new TestData().prepare();
		
		calculator = new TripWithMaxStops(towns, 2);
		
		assertEquals (0, calculator.calculate(new Town("E"), new Town("A")));
		assertEquals (1, calculator.calculate(new Town("B"), new Town("C")));
		assertEquals (1, calculator.calculate(new Town("C"), new Town("D")));
		assertEquals (1, calculator.calculate(new Town("D"), new Town("C")));
		assertEquals (1, calculator.calculate(new Town("E"), new Town("C")));

		assertEquals (2, calculator.calculate(new Town("A"), new Town("B")));
		assertEquals (2, calculator.calculate(new Town("A"), new Town("C")));
		assertEquals (2, calculator.calculate(new Town("C"), new Town("E")));
		assertEquals (2, calculator.calculate(new Town("D"), new Town("E")));
	}

	@Test public void 
	routesOfMaxThreeStops() throws Exception {
		Towns simpleGraph = new TestData().prepare();
		
		calculator = new TripWithMaxStops(simpleGraph, 3);

		assertEquals (3, calculator.calculate(new Town("A"), new Town("C")));
		assertEquals (2, calculator.calculate(new Town("C"), new Town("C")));
	}

}
