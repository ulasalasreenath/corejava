package com.hackerearth.accolite;

public class ABC4 {
    public static void main(String [] args) {
        int i = 2, j = 3, k = 10;
        for (;i < 6;i++) {
            j = (++j + k++);
            System.out.println(j+k);
        }
    }
}