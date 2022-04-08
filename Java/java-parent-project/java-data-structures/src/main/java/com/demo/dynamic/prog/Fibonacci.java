package com.demo.dynamic.prog;

public class Fibonacci {

	public static void main(String[] args) {

		int fibNo = 6;
		int[] memo = new int[fibNo + 1];
		int totalSum = fibWithMemoization(memo, fibNo);
		System.out.println(totalSum);
	}

	private static int fib(int no) {
		if (no == 0)
			return 0;
		if (no == 1)
			return 1;
		int left = fib(no - 1);
		int right = fib(no - 2);
		return left + right;
	}

	private static int fibWithArray(int no) {
		int[] result = new int[no + 1];
		result[0] = 0;
		result[1] = 1;
		for (int i = 2; i <= no; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[no];
	}

	private static int fibWithMemoization(int[] memo, int no) {
		if (memo[no] == 0) {
			if (no < 2) {
				memo[no] = no;
			} else {
				int left = fibWithMemoization(memo, no - 1);
				int right = fibWithMemoization(memo, no - 2);
				memo[no] = left + right;
			}
		}
		return memo[no];
	}

}
