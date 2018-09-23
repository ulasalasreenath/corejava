package org.speakingcs.algorithms_datastructures.sorting;

import java.util.Arrays;

public class QuickSort {

    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static int[] arr1 = {5, 1, 2, 3, 4, 6, 7, 8, 9, 10};

    public static void main(String[] args) {

        quickSort(arr1);

    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {

        if(start >= end) {
            return;
        }

        int pivot = findPivot(arr, start, end);

        System.out.println(Arrays.toString(arr));

        quickSort(arr, start, pivot-1);
        quickSort(arr, pivot+1, end);


    }

    private static int findPivot(int[] arr, int start, int end) {

        int pivotEle = arr[start];

        int low = start + 1;
        int high = end;
        while (low <= high) {
            while (arr[low] < pivotEle && low < end) {
                low++;
            }

            while (arr[high] > pivotEle) {
                high--;
            }

            if (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            } else {
                break;
            }
        }

        int temp = arr[high];
        arr[high] = pivotEle;
        arr[start] = temp;


        return high;
    }

}
