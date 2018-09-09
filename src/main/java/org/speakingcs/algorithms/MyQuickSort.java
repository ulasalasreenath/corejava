package org.speakingcs.algorithms;

import java.util.Arrays;

public class MyQuickSort {

	public static void main(String[] args) {

		int[] arr = { 5, 3, 6, 7, 2, 1, 9, 0, 45, 34, 23 };
		System.out.println("before --- " + Arrays.toString(arr));
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	private static void quicksort(int[] arr, int lowerIndex, int upperIndex) {
		
		System.out.println("lower Index ----------- " + lowerIndex);
		System.out.println("upper Index ----------- " + upperIndex);
		
		if(lowerIndex == upperIndex)
		{
			return;
		}

		int start = lowerIndex;
		int end = upperIndex;

		int pivot = (start + end) / 2;

		while (start <= end) {
			while (arr[start] < pivot) {
				start++;
			}

			while (arr[end] > pivot) {
				end--;
			}

			if (start <= end) {
				swapnumbers(start, end, arr);
				start++;
				end--;
			}
		}
		
		quicksort(arr, lowerIndex, pivot);
		quicksort(arr, pivot+1, upperIndex);
	}

	private static void swapnumbers(int start, int end, int[] arr) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

}
