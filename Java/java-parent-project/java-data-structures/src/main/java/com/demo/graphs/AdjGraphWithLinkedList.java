package com.demo.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjGraphWithLinkedList {

	List<Integer>[] adjMatrix;

	private int vertices;

	private int edges;

	public AdjGraphWithLinkedList(int vertices) {
		this.vertices = vertices;
		this.edges = 0;
		adjMatrix = new LinkedList[vertices];
		for (int i = 0; i < adjMatrix.length; i++) {
			adjMatrix[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int destination) {
		this.adjMatrix[source].add(destination);
		this.adjMatrix[destination].add(source);
		this.edges++;
	}

	public void bfs(int s) {
		boolean[] visited = new boolean[this.vertices];
		Queue<Integer> queue = new LinkedList<>();
		visited[s] = true;
		queue.offer(s);
		while (!queue.isEmpty()) {
			int u = queue.poll();
			System.out.println(" U is " + u);
			for (int adjNodes : this.adjMatrix[u]) {
				if (!visited[adjNodes]) {
					visited[adjNodes] = true;
					queue.offer(adjNodes);
				}
			}
		}
	}

	// iterative
	public void dfs(int inputVertice) {
		boolean[] visited = new boolean[this.vertices];
		Stack<Integer> stack = new Stack<>();
		visited[inputVertice] = true;
		stack.push(inputVertice);
		while (!stack.isEmpty()) {
			int vertice = stack.pop();
			System.out.println(" vertice is " + vertice);
			for (int adjNodes : this.adjMatrix[vertice]) {
				if (!visited[adjNodes]) {
					visited[adjNodes] = true;
					stack.push(adjNodes);
				}
			}
		}
	}

	// recursive
	public void dfs() {
		boolean[] visited = new boolean[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			if (!visited[i]) {
				dfs(i, visited);
			}
		}
	}

	public void dfs(int vertice, boolean[] visited) {
		visited[vertice] = true;
		System.out.println(" vertice is " + vertice);
		for (int edges : this.adjMatrix[vertice]) {
			if (!visited[edges]) {
				dfs(edges, visited);
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.vertices + " vertices " + this.edges + " edges " + "\n");
		for (int i = 0; i < this.vertices; i++) {
			sb.append(i).append(" : ");
			for (int w : this.adjMatrix[i]) {
				sb.append(w).append(",");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
