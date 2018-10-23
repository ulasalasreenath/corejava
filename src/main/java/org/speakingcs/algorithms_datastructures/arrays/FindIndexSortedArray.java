package org.speakingcs.algorithms_datastructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindIndexSortedArray {

    public static void main(String[] args) {

        List<Long> aList = new ArrayList<>();
        aList.add(51l);
        aList.add(61l);
        aList.add(81l);
        aList.add(101l);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter search value");
            //long searchVal = sc.nextLong();
            long searchVal = -100;
            int index = findIndex(aList, searchVal);
            System.out.println(aList.toString() + "value = " + searchVal + " index = " + index);
            searchVal = 51;
            System.out.println(aList.toString() + "value = " + searchVal + " index = " + findIndex(aList, searchVal));
            searchVal = 61;
            System.out.println(aList.toString() + "value = " + searchVal + " index = " + findIndex(aList, searchVal));
            searchVal = 81;
            System.out.println(aList.toString() + "value = " + searchVal + " index = " + findIndex(aList, searchVal));
            searchVal = 101;
            System.out.println(aList.toString() + "value = " + searchVal + " index = " + findIndex(aList, searchVal));
            searchVal = 41;
            System.out.println(aList.toString() + "value = " + searchVal + " index = " + findIndex(aList, searchVal));
            searchVal = 105;
            System.out.println(aList.toString() + "value = " + searchVal + " index = " + findIndex(aList, searchVal));
            searchVal = 95;
            System.out.println(aList.toString() + "value = " + searchVal + " index = " + findIndex(aList, searchVal));

        }

        //findIndex(aList);


    }

    private static int findIndex(List<Long> aList, long searchVal) {

        for (int i = 1; i <= aList.size() - 1; i++) {
            if (aList.get(i - 1) == searchVal) {
                return i;
            } else {
                if (aList.get(i - 1) < searchVal && aList.get(i) > searchVal) {
                    return i + 1;
                } else {
                    if (aList.get(i - 1) > searchVal) {
                        return i;
                    }
                }
            }

        }

        if (aList.get(aList.size() - 1) == searchVal) {
            return aList.size();
        } else //if (aList.get(aList.size() - 1) < searchVal) {
            return aList.size() + 1;
    }


}
