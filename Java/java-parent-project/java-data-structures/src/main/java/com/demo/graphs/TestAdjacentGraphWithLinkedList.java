package com.demo.graphs;

public class TestAdjacentGraphWithLinkedList {

	public static void main(String[] args) {

		testDepthFirstSearchRecursive();
	}

	private static void testData() {
		AdjGraphWithLinkedList graph = new AdjGraphWithLinkedList(4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		System.out.println(graph);
	}
	
	private static void testBreadFirstSearch() {
		AdjGraphWithLinkedList graph = new AdjGraphWithLinkedList(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		graph.addEdge(2, 4);
		graph.bfs(0);
	}
	
	private static void testDepthFirstSearchIterative() {
		AdjGraphWithLinkedList graph = new AdjGraphWithLinkedList(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		graph.addEdge(2, 4);
		graph.dfs(0);
	}
	
	private static void testDepthFirstSearchRecursive() {
		AdjGraphWithLinkedList graph = new AdjGraphWithLinkedList(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 0);
		graph.addEdge(2, 4);
		graph.dfs();
	}
	
}
