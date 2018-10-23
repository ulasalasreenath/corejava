package org.speakingcs.corejava.strings.anagrams;

import java.util.Scanner;

/**
 * given 2 strings in lower case, you need to find minimum number of characters to remove
 * in order to make both strings as anagrams to each other
 */
public class RemoveCharsToMakeAnagrams {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter 2 strings");
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int minimum_number = findMinCharsToRemove(str1, str2);

            System.out.println("Minimum number of characters to remove is " + minimum_number);
        }
    }


    public static int findMinCharsToRemove(String str1, String str2) {

        char[] str1CharArr = new char[26];
        char[] str2CharArr = new char[26];

        for(int i = 0; i < str1.length(); i++) {
            str1CharArr[str1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < str2.length(); i++) {
            str2CharArr[str2.charAt(i) - 'a']++;
        }

        int count = 0;
        for(int i = 0; i < 26; i++) {
            count += Math.abs(str1CharArr[i] - str2CharArr[i]);
        }
        return count;
    }
}
