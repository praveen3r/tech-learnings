package com.demo.array.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {

	public static void main(String[] args) {
		int[] input = {2, 1, 0, 3, 4, 7};
		int target = 6;
		getPairs(input, target);
	}

	private static List<List<Integer>> getPairs(int[] input, int target) {
		Arrays.sort(input);
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i< input.length-2; i++) {
			int j= i+1;
			int k= input.length-1;
			while(j < k) {
				int sum = input[i] + input[j] + input[k];
				if(sum == target) {
					List<Integer> pair = new ArrayList<>();
					pair.add(input[i]);
					pair.add(input[j]);
					pair.add(input[k]);
					result.add(pair);
					j++;
					k--;
				}
				else if(sum < target) {
					j++;
				}
				else {
					k--;
				}
			}
		}
		System.out.println(result);
		return result;
	}
}
