package org.toztemel.trains.output;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.toztemel.trains.TestData;
import org.toztemel.trains.graph.Town;
import org.toztemel.trains.graph.Graph;

public class TaskTest {

	private Display display;
	private Graph prepare;

	@Before public void
	setup() throws Exception {
		display = new Display();
		prepare = new TestData().prepare();
	}
	
	@Test
	public void 
	task1Is9() throws Exception {
		display = new Display();
		Task t = new DistanceCalculation(prepare, display, new Town("A"), new Town("B"), new Town("C"));
		t.execute();

		assertEquals("11", display.getResult());
	}
	
	@Test
	public void 
	task2Is5() throws Exception {
		Task t = new DistanceCalculation(new TestData().prepare(), display, new Town("A"), new Town("D"));
		t.execute();

		assertEquals("5", display.getResult());
	}
	
	@Test
	public void 
	task3Is13() throws Exception {
		Task t = new DistanceCalculation(new TestData().prepare(), display, new Town("A"), new Town("D"), new Town("C"));
		t.execute();

		assertEquals("15", display.getResult());
	}
	
	@Test
	public void 
	task4Is22() throws Exception {
		Task t = new DistanceCalculation(new TestData().prepare(), display, new Town("A"), new Town("E"), new Town("B"), new Town("C"), new Town("D"));
		t.execute();

		assertEquals("28", display.getResult());
	}
	
	@Test
	public void 
	task5IsNOSUCHROUTE() throws Exception {
		Task t = new DistanceCalculation(new TestData().prepare(), display, new Town("A"), new Town("E"), new Town("D"));
		t.execute();

		assertEquals("NO SUCH ROUTE", display.getResult());
	}

	
	@Test
	public void 
	task6Is2() throws Exception {
		Task t = new RouteWithMaxStopCalculation(new TestData().prepare(), display, new Town("C"), new Town("C"));
		t.execute();

		assertEquals("2", display.getResult());
	}
	
	@Test
	public void 
	task7Is3() throws Exception {
		Task t = new RouteWithExactStopCalculation(new TestData().prepare(), display, new Town("A"), new Town("C"));
		t.execute();

		assertEquals("3", display.getResult());
	}
	
	@Test
	public void 
	task8Is9() throws Exception {
		Task t = new ShortestPathCalculation(new TestData().prepare(), display, new Town("A"), new Town("C"));
		t.execute();

		assertEquals("11", display.getResult());
	}
	
	@Test
	public void 
	task9Is9() throws Exception {
		Task t = new ShortestPathCalculation(new TestData().prepare(), display, new Town("B"), new Town("B"));
		t.execute();

		assertEquals("13", display.getResult());
	}
	
	@Test
	public void 
	task10Is7() throws Exception {
		Task t = new RouteOfMaxLengthCalculation(new TestData().prepare(), display, new Town("C"), new Town("C"));
		t.execute();

		assertEquals("7", display.getResult());
	}

}
