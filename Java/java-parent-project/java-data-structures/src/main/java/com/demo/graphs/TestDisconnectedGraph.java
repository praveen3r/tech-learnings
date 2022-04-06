package com.demo.graphs;

public class TestDisconnectedGraph {

	public static void main(String[] args) {

		testDepthFirstSearch();
	}

	private static void testDepthFirstSearch() {
		int vertices = 7;
		DisconnectedGraph graph = new DisconnectedGraph(vertices);
		graph.addEdge(1, 3);
		graph.addEdge(3, 2);
		graph.addEdge(0, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
	    graph.dfs();
		
		System.out.println("count of connected edges "+ graph.getCount());
		
		boolean isConnected = graph.isConnected(1, 2);
		
		System.out.println(isConnected);
	}
	
	

}
