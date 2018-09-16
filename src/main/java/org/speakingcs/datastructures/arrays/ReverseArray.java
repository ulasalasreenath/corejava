package org.speakingcs.datastructures.arrays;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,8};

        System.out.println("Original array " + Arrays.toString(a));
        int[] b = reverseArray(a);
        System.out.println("Reversed array " + Arrays.toString(b));
    }

    private static int[] reverseArray(int[] a) {

        int[] b = new int[a.length];
        int j = 0;

        for(int i = a.length -1 ; i >= 0; i--) {
            b[j++] = a[i];
        }
        return b;
    }
}
