package com.demo.programs;

/* Given an integer N, returns the smallest integer greater than N,
 * the sum of two digits is twice as big as the sum of digits of N
 * 
 * Example 
 * 
 * Given N as 14, the function should return 19. The sum of digits 19 (1 + 9 = 10 )
 * is twice as big as the sum of digits of 14 (1 + 4 = 5)
 * 
 * Given N is 10, the function should return 11
 * 
 * Given N is 99, the function should return 9999
 * 
 */
public class TwiceTheSumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no = solution(14);
		System.out.println(no);
	}

	public static int solution(int N) {
        // write your code in Java SE 11
		int sumOfDigits = getSumOfDigits(N);
		int twiceSumOfDigits = 2 * sumOfDigits;
		return getNumberWithTwiceSumOfDigits(N, twiceSumOfDigits);
    }

	private static int getSumOfDigits(int N) {
		int sum = 0;
        if(N!=0) {
        	while (N != 0) {
        		sum = sum + N % 10;
        		N = N/10;
        	}
        }
        return sum;
    }
	
	private static int getNumberWithTwiceSumOfDigits(int no, int sumOfDigits) {
		while (sumOfDigits != getSumOfDigits(no)){
			no = no + 1;
		}
		return no;
        
    }
}
