package org.speakingcs.datastructures.arrays;

public class RotateArray {

    static int[][] arr1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    static int[] arr2;

    public static void main(String[] args) {

        printArr(arr1);
        rotateArr(arr1, 4, 4);
        System.out.println();
        printArr(arr1);

    }

    private static void rotateArr(int[][] arr, int noOfRows, int noOfCols) {

        int rowIndex = 0, colIndex = 0;

        while(rowIndex < noOfRows && colIndex < noOfCols) {

            System.out.println("===============================================");
            if(rowIndex +1 == noOfRows || colIndex +1 == noOfCols) {
                break;
            }
            int prev = arr[rowIndex + 1][colIndex];


            /**
             * rotate top row
             */
            for (int i = colIndex; i < noOfCols; i++) {
                int curr = arr[rowIndex][i];
                arr[rowIndex][i] = prev;
                prev = curr;
            }
            rowIndex++;

            printArr(arr);
            /**
             * rotate last column
             */

            for (int i = rowIndex; i < noOfRows; i++) {
                int curr = arr[i][noOfCols - 1];
                arr[i][noOfCols - 1] = prev;
                prev = curr;
            }
            noOfCols--;
            printArr(arr);
            /**
             * rotate bottom row
             */
            for (int i = noOfCols - 1; i >= colIndex; i--) {
                int curr = arr[noOfRows - 1][i];
                arr[noOfRows - 1][i] = prev;
                prev = curr;
            }
            noOfRows--;
            printArr(arr);
            /**
             * rotate first column
             */
            for (int i = noOfRows - 1; i >= rowIndex; i--) {
                int curr = arr[i][colIndex];
                arr[i][colIndex] = prev;
                prev = curr;
            }
            printArr(arr);
            colIndex++;
        }
    }

    private static void printArr(int[][] arr1) {

        for(int i = 0; i < arr1.length; i++) {
            int[] arr2 = arr1[i];
            for(int j = 0; j < arr2.length; j++) {
                System.out.printf("%d\t", arr2[j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
