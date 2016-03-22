package org.toztemel.trains;

import org.toztemel.trains.graph.Towns;
import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.GraphBuilder;

public class TestData {

	public Towns prepare() throws NoSuchTownException {
		Towns graph = new Towns();
		GraphBuilder builder = new GraphBuilder(graph);
		builder.addToGraph("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7".split(","));
		return graph;
	}

}
