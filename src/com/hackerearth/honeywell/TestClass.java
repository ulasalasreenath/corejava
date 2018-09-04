package com.hackerearth.honeywell;

import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        
        //Scanner
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int sizeOfArr = sc.nextInt();
            int[] arr = new int[sizeOfArr];
            for(int j = 0; j < sizeOfArr; j++)
            {
                arr[j] = sc.nextInt();
            }
         System.out.println(getMaxOddSum(arr));   
        }
        sc.close();
        
    }
    
    private static int getMaxOddSum(int[] a) {

		int[] sum = new int[a.length];

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			sum[i] = a[i];
			int sumAtI = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				int sum1 = sum[j] + sum[i];

				if (sum1 % 2 != 0) {

					if(sum1 > sumAtI)
					{
						sumAtI = sum1;
					}
					/*if (sum1 > max) {
						max = sum1;
						sum[i] = sum1;
					}*/
				}

				/*if (sum1 > sum[i]) {
					sum[i] = sum1;
				}*/
			}
			
			if(sumAtI != Integer.MIN_VALUE)
			{
				sum[i] = sumAtI;
			}
			

			if (sum[i] % 2 != 0) {
				if(sum[i] > max)
				{
					max = sum[i];
				}
			}

		}

		return max;

	}
}
