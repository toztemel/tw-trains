package org.toztemel.trains.trips;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.toztemel.trains.TestData;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Towns;

public class DifferentRoutesOfMaxLengthTest {

	Trip trip;
	Towns towns;
	Town a = new Town("A");
	Town b = new Town("B");
	Town c = new Town("C");
	
	@Before public void
	setup() throws Exception {
		towns = new TestData().prepare();
		
	}
	
	@Test
	public void 
	routesOfAdjacentTowns() throws Exception {
		assertEquals(0, new DifferentRoutesOfMaxLength(towns, 5).calculate(a, b));
		assertEquals(1, new DifferentRoutesOfMaxLength(towns, 6).calculate(a, b));
		assertEquals(1, new DifferentRoutesOfMaxLength(towns, 10).calculate(a, b));
		assertEquals(2, new DifferentRoutesOfMaxLength(towns, 11).calculate(a, b));
		assertEquals(2, new DifferentRoutesOfMaxLength(towns, 14).calculate(a, b));
		assertEquals(4, new DifferentRoutesOfMaxLength(towns, 15).calculate(a, b));
	}

	@Test
	public void 
	routesOfDifferentTowns() throws Exception {
		assertEquals(0, new DifferentRoutesOfMaxLength(towns, 9).calculate(c, c));
		assertEquals(1, new DifferentRoutesOfMaxLength(towns, 10).calculate(c, c));
		assertEquals(1, new DifferentRoutesOfMaxLength(towns, 16).calculate(c, c));
		assertEquals(2, new DifferentRoutesOfMaxLength(towns, 17).calculate(c, c));
		assertEquals(7, new DifferentRoutesOfMaxLength(towns, 30).calculate(c, c));
	}
	
}