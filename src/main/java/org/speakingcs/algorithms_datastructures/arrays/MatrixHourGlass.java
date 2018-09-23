package org.speakingcs.algorithms_datastructures.arrays;

public class MatrixHourGlass {

    static int[][] arr = new int[6][6];

    public static void main(String[] args) {
        int maxSum = hourglassSum(arr);
    }

    private static int hourglassSum(int[][] arr) {

        int sum = Integer.MIN_VALUE;

        for(int row = 0; row < arr.length -2 ; row++) {
            for(int col = 0; col < arr.length-2; col++) {
                int row1Sum = arr[row][col] + arr[row][col+1]+arr[row][col+2];
                int row2Sum = arr[row+1][col+1];
                int row3Sum = arr[row+2][col] + arr[row+2][col+1]+arr[row+2][col+2];

                int sum1 = row1Sum + row2Sum + row3Sum;
            }
        }

        return 0;
    }
}
