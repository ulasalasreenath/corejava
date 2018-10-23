package com.hackerearth.tcs;

import java.util.Scanner;

public class MatrixMaximization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        long[][] matrix = new long[m][n];

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                matrix[i][j] = sc.nextLong();
            }

        }

        long maxSum = findMatrixSum(matrix, m , n);

        // remove row by row
        for(int i = 0;i < m; i++) {
            long sum = findSumByRemovingRow(matrix, i, m, n);
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        
        // remove column
        for(int j = 0; j < n; j++) {
            long sum = findSumByRemovingCol(matrix, j, m, n);
            if(sum > maxSum) {
                maxSum = sum;
            }
        }

        System.out.println(maxSum);

    }

    private static long findMatrixSum(long[][] matrix, int m, int n) {

        long total = 0;
        for(int i = 0; i < m ; i++) {
            long rowSum = 0;
            for(int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
            }
            total += rowSum;
        }
        System.out.println("total sum " + total);
        return total;
    }

    private static long findSumByRemovingCol(long[][] matrix, int colNum, int m, int n) {
        long sum = 0;

        for(int rowCount = 0; rowCount <m; rowCount++) {

            long rowSum = 0;
            for(int colCount = 0; colCount < n; colCount++) {

                if(colCount == colNum) {
                    continue;
                }

                rowSum += matrix[rowCount][colCount];
            }

            sum += rowSum;

        }
        return sum;
    }

    private static long findSumByRemovingRow(long[][] matrix, int rowNum, int rows, int cols) {

        long sum = 0;

        for(int rowCount = 0; rowCount < rows; rowCount++) {

            if(rowCount == rowNum) {
                continue;
            }

            long rowSum = 0;
            for(int colCount = 0; colCount < cols; colCount++) {
                rowSum += matrix[rowCount][colCount];
            }
            sum+=rowSum;
        }

        return sum;
    }
}
