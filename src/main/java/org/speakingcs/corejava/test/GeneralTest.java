package org.speakingcs.corejava.test;

import java.util.Arrays;
import java.util.Comparator;

public class GeneralTest {

    static String test = "test";

    public static void main(String[] args)
    {
        String str = "abc";

        str = "abc   cde";
        System.out.println(Arrays.toString(str.split(" ")));

        char[] chars = str.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);

        System.out.println(new String(chars));


    }

    /**
     * you can access static variables from non static context
     */
    public void testStatic() {
        System.out.println(test);
    }

    public static String arrange(String sentence) {
        // Write your code here
        String[] words = sentence.split(" ");
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        StringBuilder result = new StringBuilder();
        String finalStr = "";
        for(int i = 0;i < words.length; i++) {
            finalStr = words[i];
            if(i == 0) {
                String aWord = words[i];
                char[] charArr = aWord.toCharArray();
                charArr[0] = Character.toUpperCase(charArr[0]);
                finalStr = new String(charArr);

            }
            if(i < words.length-1) {
                result.append(finalStr);
                result.append(" ");
            }

            if(i == words.length-1) {
                result.append(finalStr);
                result.append(".");
            }

        }

        return result.toString();

    }
}
