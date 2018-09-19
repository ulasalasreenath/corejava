package org.speakingcs.algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 * Longest common subsequence dynamic programming
 * https://www.sanfoundry.com/java-program-longest-common-subsequence-algorithm/
 */
public class LongestCommonSubsequenceDP {

    static int[][] memory = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first String" );
        String str1 = sc.nextLine();
        System.out.println("Enter second String");
        String str2 = sc.nextLine();

        memory = new int[str1.length()+1][str2.length()+1];
        int lcs = findLCS(str1, str2);
        System.out.println("Length of longest common subsequence is " + lcs);
        printSubSequence(str1, str2);

    }

    private static void printSubSequence(String str1, String str2) {

        int i = 0, j = 0;

        StringBuilder builder = new StringBuilder();
        while(i < str1.length() && j < str2.length()) {
            if(str1.charAt(i) == str2.charAt(j)) {
                builder.append(str1.charAt(i));
                i++;
                j++;
            } else if(memory[i+1][j] >= memory[i][j+1]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println("substring is " + builder);

    }

    private static int findLCS(String str1, String str2) {
        return findLCS1(str1, str1.length(), str2, str2.length());
    }

    private static int findLCS1(String str1, int length, String str2, int length1) {

        for(int i = length -1; i >= 0; i--) {
            for(int j = length1 -1 ; j >= 0; j--) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    memory[i][j] = 1 + memory[i+1][j+1];
                } else {
                    memory[i][j] = Integer.max(memory[i+1][j], memory[i][j+1]);
                }
            }
        }
        return memory[0][0];
    }
}
