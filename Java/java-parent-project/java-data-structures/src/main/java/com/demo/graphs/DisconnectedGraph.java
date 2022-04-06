package com.demo.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DisconnectedGraph {

	List<Integer>[] adjMatrix;

	private int vertices;

	private int edges;
	
    private int[] connectedComp;
	
	private int count;

	public DisconnectedGraph(int vertices) {
		this.vertices = vertices;
		this.edges = 0;
		adjMatrix = new LinkedList[vertices];
		connectedComp = new int[vertices];
		for (int i = 0; i < adjMatrix.length; i++) {
			adjMatrix[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int destination) {
		this.adjMatrix[source].add(destination);
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

	public void dfs() {
		boolean[] visited = new boolean[this.vertices];
		for (int i = 0; i < this.vertices; i++) {
			if (!visited[i]) {
				dfs(i, visited, connectedComp, count);
				count++;
			}
		}
	}
	
	public void dfs(int vertice, boolean[] visited, int[] connectedComp, int count) {
		visited[vertice] = true;
		connectedComp[vertice] = count;
		System.out.println(" vertice is " + vertice);
		for (int edges : this.adjMatrix[vertice]) {
			if (!visited[edges]) {
				dfs(edges, visited, connectedComp, count);
			}
		}
	}
	
	public  boolean isConnected(int source, int destination) {
		return this.connectedComp[source] == this.connectedComp[destination];
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

	public int getCount() {
		return count;
	}

}
