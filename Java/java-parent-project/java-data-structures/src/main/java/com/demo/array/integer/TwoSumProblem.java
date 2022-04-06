package com.demo.array.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Return the pair of index of integers from the array who sum is the target
 */
public class TwoSumProblem {

	public static void main(String[] args) {

		int[] input = {2, 11, 5, 10, 7, 5};
		int target = 9;
		getPairsWithoutMap(input, target);
	}
	
	private static List<Integer> getPairs(int[] input, int target) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i< input.length; i++) {
			int difference = target - input[i];
			if(!map.containsKey(difference)) {
				map.put(input[i], i);
			}else {
				result.add(map.get(difference));
				result.add(i);
			}
		}
		System.out.println(result);
		return result;
		
	}

	private static List<List<Integer>> getPairsWithoutMap(int[] input, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int left = 0;
		int right = input.length-1;
		Arrays.sort(input);
		while(left < right) {
			int sum = input[left] + input[right];
			if(sum == target) {
				List<Integer> pair = new ArrayList<>();
				pair.add(input[left]);
				pair.add(input[right]);
				result.add(pair);
			}
			if(sum > target) {
				right--;
			}else {
				left++;
			}
		}
		System.out.println(result);
		return result;
	}
}
