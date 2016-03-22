package org.toztemel.trains.trips;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.toztemel.trains.TestData;
import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Graph;
import org.toztemel.trains.exception.NoSuchRouteException;

public class DistanceCalculatorTest {

	Graph graph;
	private Trip calculator;

	@Before public void 
	setUp() throws Exception {
		graph = new TestData().prepare();
		calculator = new DistanceCalculator(graph);
	}

	@Test(expected=NoSuchRouteException.class) public void 
	throwsExceptionIfNoSuchRoute() throws Exception {
		calculator.calculate(new Town("A"), new Town("E"), new Town("D"));
		fail("Should throw exception if route does not exist");
	}
	
	@Test(expected=NoSuchRouteException.class) public void 
	throwsExceptionIfNoSuchDestTown() throws Exception {
		calculator.calculate(new Town("A"), new Town("F"));
		fail("Should throw exception if town does not exist");
	}

	@Test(expected=NoSuchTownException.class) public void
	throwsExceptionIfNoSuchSourceTown() throws Exception {
		calculator.calculate(new Town("F"), new Town("A"));
		fail("Should throw exception if town does not exist");
	}

	@Test public void 
	canFindTripDistanceBetweenAdjacentTowns() throws Exception {
		assertEquals (5, calculator.calculate(new Town("A"), new Town("B")));
		assertEquals (4, calculator.calculate(new Town("B"), new Town("C")));
		assertEquals (8, calculator.calculate(new Town("C"), new Town("D")));
		assertEquals (8, calculator.calculate(new Town("D"), new Town("C")));
		assertEquals (6, calculator.calculate(new Town("D"), new Town("E")));
		assertEquals (5, calculator.calculate(new Town("A"), new Town("D")));
		assertEquals (2, calculator.calculate(new Town("C"), new Town("E")));
		assertEquals (3, calculator.calculate(new Town("E"), new Town("B")));
		assertEquals (7, calculator.calculate(new Town("A"), new Town("E")));
	}
	
	@Test public void 
	canSumTotalTripDistanceOfMultipleTowns() throws Exception {
		assertEquals (11, calculator.calculate(new Town("A"), new Town("B"), new Town("C")));
		assertEquals (5, calculator.calculate(new Town("A"), new Town("D")));
		assertEquals (15, calculator.calculate(new Town("A"), new Town("D"), new Town("C")));
		assertEquals (28, calculator.calculate(new Town("A"), new Town("E"), new Town("B"), new Town("C"), new Town("D")));
	}
}
