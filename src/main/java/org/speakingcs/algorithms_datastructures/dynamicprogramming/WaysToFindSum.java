package org.speakingcs.algorithms_datastructures.dynamicprogramming;

import java.util.Scanner;

public class WaysToFindSum {

    static int[] denominations = {1, 3, 5, 7};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total sum");
        int totalSum = sc.nextInt();

        int totalWays = findTotalWays(denominations, totalSum);
        System.out.println("Total number of ways " + totalWays);


    }

    private static int findTotalWays(int[] denominations, int totalSum) {


        if (totalSum < 0) {
            return 0;
        }

        /**
         * 1-1, 3-3, 5-5, 7-7
         */
        if (totalSum == 0) {
            return 1;
        }

        int result = 0;
        for (int i = 0; i < denominations.length; i++) {

            result += findTotalWays(denominations, totalSum - denominations[i]);

        }

        return result;


    }

}
