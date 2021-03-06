package org.speakingcs.corejava.threads.cyclicBarrier;

import java.util.Random;

/**
 * Generates a random matrix of numbers between 1 and 10
 */
public class MatrixMock {

    private int data[][];



    public MatrixMock(int size, int length, int number) {
        int counter = 0;
        data = new int[size][length];
        Random random = new Random();

        // fill the matrix with random numbers

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < length; j++) {
                data[i][j] = random.nextInt(10);
                if(data[i][j] == number) {
                    counter++;
                }

            }
        }
        System.out.printf("Mock: There are %d occurrences of number in generated data. \n", counter, number);

    }

    public int[] getRow(int row) {
        if((row >= 0) && (row < data.length)) {
            return data[row];
        }
        return null;
    }
}
