package org.speakingcs.algorithms_datastructures.dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.ics.uci.edu/~eppstein/161/960229.html -- for recursive approach with memorization
 * https://www.sanfoundry.com/java-program-longest-common-subsequence-algorithm/ -- for finding subsequence
 */
public class LongestCommonSubsequenceRecursive {

    static int[][] memory = null;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1");
        String str1 = sc.nextLine();
        System.out.println("Enter String 2");
        String str2 = sc.nextLine();

        //int lcs = findLCS("abc", "abc");
        int lcs = findLCS(str1, str2);
        System.out.println("Longest common subsequence is " + lcs);

        for (int i = 0; i < memory.length; i++) {
            for (int j = 0; j < memory[i].length; j++) {
                System.out.printf("%d", memory[i][j]);
            }
            System.out.println();
        }

        // printing string
        int i = 0, j = 0;
        int len1 = str1.length();
        int len2 = str2.length();

        StringBuilder substr = new StringBuilder();
        while (i < len1 && j < len2) {
            if (str1.charAt(i) == str2.charAt(j)) {
                substr.append(str1.charAt(i));
                i++;
                j++;
            } else if(memory[i+1][j] == -1 && memory[i+1][j] == -1) {
                i++;
                j++;
            }
            else if (memory[i+1][j] >= memory[i][j+1]) {
                i++;
            } else {
                j++;
            }
        }


        System.out.println("The substring is " + substr);


    }

    private static int findLCS(String str1, String str2) {

        memory = new int[str1.length()+1][str2.length()+1];

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                memory[i][j] = -1;
            }
        }


        return findLCS1(str1, str1.length() - 1, str2, str2.length() - 1);
    }

    private static int findLCS1(String str1, int len1, String str2, int len2) {

        if (len1 == -1 || len2 == -1) {
            return 0;
        }

        if (memory[len1][len2] != -1) {
            return memory[len1][len2];
        }

        if (str1.charAt(len1) == str2.charAt(len2)) {
            memory[len1][len2] = 1 + findLCS1(str1, len1 - 1, str2, len2 - 1);
            return memory[len1][len2];
        } else {
            memory[len1][len2] = Integer.max(findLCS1(str1, len1 - 1, str2, len2),
                                             findLCS1(str1, len1, str2, len2 - 1));
            return memory[len1][len2];
        }
    }
}
