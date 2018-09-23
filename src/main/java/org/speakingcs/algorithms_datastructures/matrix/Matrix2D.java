package org.speakingcs.algorithms_datastructures.matrix;

public class Matrix2D {

    static int[][] a = new int[5][5];

    public static void main(String[] args) {

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                System.out.printf("%d", a[i][j]);
            }
            System.out.println();
        }

    }
}
