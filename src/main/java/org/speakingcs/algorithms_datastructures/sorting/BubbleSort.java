package org.speakingcs.algorithms_datastructures.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {5, 4, 8, 9, 1, 10, 7};
        Scanner sc = new Scanner(System.in);
        System.out.println("enter numbers to sort");
        String values = sc.next();
        //Arrays.stream(values.split(" ")).mapToInt((s) -> Integer.parseInt(s)).collect(Collectors.toList());
        List<Integer> integerList = Arrays.stream(values.split(" ")).map((s) -> Integer.parseInt(s)).collect(
                Collectors.toList());


        System.out.println("Before sorting " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After sorting " + Arrays.toString(arr));

    }

    private static void bubbleSort(int[] arr) {

        for(int i = 0; i < arr.length-1; i++) {
            for(int j = 0; j < arr.length-1; j++) {

                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }

            }
        }


    }

}
