package com.demo.graphs;

public class AdjGraphWithMatrix {
	
	int[][] adjMatrix;

	public AdjGraphWithMatrix(int nodes) {
		adjMatrix = new int[nodes][nodes];
	}
	
	public void addEdge(int source, int destination) {
		adjMatrix[source][destination] = 1;
		adjMatrix[destination][source] = 1;
	}
	
	

}
