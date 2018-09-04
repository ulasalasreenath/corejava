package com.speakingcs.hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class SubArrayFunctions {

	int maxAndValue = 0;
	int left = 0;
	int right = 0;
	int largestLength = 0;

	public static void main(String[] args) {
		SubArrayFunctions saf = new SubArrayFunctions();

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arrLength = 0;
		int M = 0;
		int P = 0;
		
		for(int i = 0; i < N; i++)
		{
			arrLength = sc.nextInt();
			M = sc.nextInt();
			P = sc.nextInt();
			int[] a = new int[arrLength];
			for(int j = 0; j < arrLength; j++)
			{
				a[j] = sc.nextInt();
			}
			
			saf.left = 0;
			saf.right = 0;
			saf.maxAndValue = 0;
			saf.largestLength = 0;
			
			for (int k = 0; k < a.length; k++) {
				
				if(M == P)
				{
					int temp = M;
					while(temp < a.length){
						saf.generateSubArrays(a, k, temp, M, P);
						temp++;
					}
				} else
				{
					int temp = M;
					while(temp < a.length) {
						saf.generateSubArrays(a, k, temp, M, P);
						temp++;
					}
					temp = P;
					while(temp < a.length){
						saf.generateSubArrays(a, k, temp, M, P);
						temp++;
					}
				}
			}
			
			System.out.println(saf.left +" " + saf.right + " " + saf.maxAndValue);
		}
	}

	private void generateSubArrays(int[] a, int l, int noOfElements, int m2, int p2) {

		int left = l;
		int right = l + noOfElements -1 ;
		
		if(right >= a.length)
		{
			return;
		}
		
		left = a[left];
		right = a[right];

		if (left > right) {
			return;
		}
		
		if(!(right - left + 1 >= noOfElements)) {
			return;
		}

		int[] copiedArr = Arrays.copyOfRange(a, l, l+noOfElements);
		

		/*for (int i = 0; i < copiedArr.length; i++) {
			System.out.print(copiedArr[i]);
		}*/
		
		Arrays.sort(copiedArr);
		
		/*for (int i = 0; i < copiedArr.length; i++) {
			System.out.print(copiedArr[i]);
		}
		System.out.println();*/
		
		int minFinalXOR = copiedArr[0];
		//int firstElement = copiedArr[0];
		
		if(m2 > noOfElements)
			return;
		
		for(int i = 1 ; i < m2; i++)
		{
			minFinalXOR ^= copiedArr[i];
		}
		
		//System.out.println("min Final XOR " + minFinalXOR);
		int maxFinalXOR = copiedArr[copiedArr.length - 1];
		
		//int p = noOfElements-1;
		if( p2 > copiedArr.length) {
			return;
		}
		int p = p2 -1;
		for(int i = copiedArr.length -2;p !=0; i--, p--)
		{
			maxFinalXOR ^= copiedArr[i];
		}
		
		//System.out.println("max Final XOR " + maxFinalXOR);
		//System.out.println(minFinalXOR & maxFinalXOR);
		
		int maxAndValue = minFinalXOR & maxFinalXOR;
		
		if(this.maxAndValue < maxAndValue)
		{
			this.maxAndValue = maxAndValue;
			this.left = left;
			this.right = right;
			largestLength = copiedArr.length;
		}
		
		if(this.maxAndValue == maxAndValue)
		{
			int length = copiedArr.length;
			
			if(largestLength < length)
			{
				this.left = left;
				this.right = right;
				largestLength = copiedArr.length;
			} else if(largestLength == length)
			{
				if(this.left > left)
				{
					this.left = left;
					this.right = right;
				}
			}
		}
	}
}
