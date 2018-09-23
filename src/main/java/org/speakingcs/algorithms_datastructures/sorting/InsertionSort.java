package org.speakingcs.algorithms_datastructures.sorting;

import java.util.Arrays;

public class InsertionSort {


    public static void main(String[] args) {
        int[] arr = {10, 8, 7, 11, 12, 13, 1, 2, 3};

        System.out.println("Before sorting " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After sorting " + Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {

        for(int i = 1; i < arr.length; i++) {

            for(int j = i; j > 0; j--) {

                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
