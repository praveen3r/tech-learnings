package com.demo.graphs;

public class TestAdjacentGraphWithMatrix {

	public static void main(String[] args) {

		AdjGraphWithMatrix graph = new AdjGraphWithMatrix(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
	}

}
