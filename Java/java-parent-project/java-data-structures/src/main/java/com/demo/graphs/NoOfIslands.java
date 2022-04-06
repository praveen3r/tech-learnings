package com.demo.graphs;

public class NoOfIslands {

	public static void main(String[] args) {
		int[][] input = new int[4][4];
		populateArray(input);
		int count = noOfIslands(input);
		System.out.println("no of islands are "+ count);
	}
	
	private static void populateArray(int[][] input) {
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[i].length; j++) {
				input[i][j] = 0;
			}
		}
		input[0][0] = 1;
		input[0][1] = 1;
		input[1][0] = 1;
		input[2][2] = 1;
		input[3][3] = 1;
	}
	
	private static int noOfIslands(int[][] input) {
		int noOfIslands = 0;
		boolean[][] visited = new boolean[input.length][input[0].length];
		for(int i=0; i<input.length; i++) {
			for(int j=0; j<input[i].length; j++) {
				if(!visited[i][j] && input[i][j]==1) {
					dfs(input, i, j, visited);
					noOfIslands++;
				}
			}
		}
		return noOfIslands;
	}
	
	private static void dfs(int[][] input, int row, int column, boolean[][] visited) {
		if(row< 0 || column< 0 || row>=input.length || column>=input[0].length ||
				visited[row][column] || input[row][column] == 0) {
			return;
		}
		visited[row][column] = true;
		dfs(input, row-1, column, visited);
		dfs(input, row, column-1, visited);
		dfs(input, row+1, column, visited);
		dfs(input, row, column+1, visited);
	}

}
