package com.hackerearth.honeywell;

import java.util.Scanner;

public class StampTheMatrix {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long T = sc.nextInt();
		long M, N, K;
		for (int i = 0; i < T; i++) {
			M = sc.nextLong();
			N = sc.nextLong();
			K = sc.nextLong();

			System.out.println(getMaxNoOfStamps(M, N, K));
		}

		sc.close();

	}

	private static long getMaxNoOfStamps(long m, long n, long k) {

		long totalNoOfCells = m * n;
		if (totalNoOfCells <= k) {
			return totalNoOfCells;
		} else {
			while (true) {
				if (isPerfectSquareAndInBoundaries(k, m, n)) {
					return k;
				} else if(isDivisible(k, m, n)){
					return k;
				}
				k--;
			}
		}

		//return 0;
	}

	private static boolean isDivisible(long k, long m, long n) {

		if (k % m == 0 || k % n == 0) {
			return true;
		}
		return false;
	}

	private static boolean isPerfectSquareAndInBoundaries(long k, long m, long n) {

		boolean isPerfectSquare = false;
		boolean isInBoundaries = false;
		
		int sqrt = (int) Math.sqrt(k);

		if (sqrt * sqrt == k) {
			isPerfectSquare = true;
		}

		if(sqrt <= m && sqrt <= n)
		{
			isInBoundaries = true;
		}
		
		return isPerfectSquare && isInBoundaries;
	}

}
