package org.toztemel.trains;

import org.toztemel.trains.graph.Graph;
import org.toztemel.trains.exception.NoSuchTownException;
import org.toztemel.trains.graph.GraphBuilder;

public class TestData {

	public Graph prepare() throws NoSuchTownException {
		Graph graph = new Graph();
		GraphBuilder builder = new GraphBuilder(graph);
		builder.addToGraph("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7".split(","));
		return graph;
	}

}
