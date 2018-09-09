package com.hackerearth.honeywell;

public class BestSubSequence {

	public static void main(String[] args) {

		int[] a = { -3, -10, 2 };
		int[] b = { -2, 2, 1, -3 };

		System.out.println(getMaxOddSum(a));
		System.out.println(getMaxOddSum(b));
	}

	private static int getMaxOddSum(int[] a) {
		
		int minOddNumber = Integer.MAX_VALUE;
		int sum = 0;
		
		for(int i = 0; i < a.length; i++)
		{
			
			if(a[i] > 0)
			{
				sum += a[i];
			}
			
			if(a[i] % 2 != 0)
			{
				if(Math.abs(a[i]) < minOddNumber) {
					minOddNumber = Math.abs(a[i]);
				}
			}
		}
		
		if(sum %2 == 0)
		{
			sum -= minOddNumber;
		}
		
		
		
		return sum;
	}

	/*
	 * private static int getMaxOddSum(int[] a) {
	 * 
	 * int[] sum = new int[a.length];
	 * 
	 * int max = Integer.MIN_VALUE;
	 * 
	 * for (int i = 0; i < a.length; i++) { sum[i] = a[i]; int sumAtI =
	 * Integer.MIN_VALUE; for (int j = 0; j < i; j++) { int sum1 = sum[j] +
	 * sum[i];
	 * 
	 * if (sum1 % 2 != 0) {
	 * 
	 * if(sum1 > sumAtI) { sumAtI = sum1; } if (sum1 > max) { max = sum1; sum[i]
	 * = sum1; } }
	 * 
	 * if (sum1 > sum[i]) { sum[i] = sum1; } }
	 * 
	 * if(sumAtI != Integer.MIN_VALUE) { sum[i] = sumAtI; }
	 * 
	 * 
	 * if (sum[i] % 2 != 0) { if(sum[i] > max) { max = sum[i]; } }
	 * 
	 * }
	 * 
	 * return max;
	 * 
	 * }
	 */
}
