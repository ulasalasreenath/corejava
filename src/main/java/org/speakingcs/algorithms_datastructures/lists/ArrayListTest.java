package org.speakingcs.algorithms_datastructures.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {

    static class A{

        private String str1 = null;
        private String str2 = null;

        public String getStr1() {
            return str1;
        }

        public void setStr1(String str1) {
            this.str1 = str1;
        }

        public String getStr2() {
            return str2;
        }

        public void setStr2(String str2) {
            this.str2 = str2;
        }

        public A() {

        }

        public A(String str1, String str2) {
            this.str1 = str1;
            this.str2 = str2;
        }

        @Override
        public String toString() {
            return "A{" +
                    "str1='" + str1 + '\'' +
                    ", str2='" + str2 + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {


        List<A> aList = new ArrayList<>();

        A a = new A("STR1", null);
        A a2 = new A("STR1", "STR2");

        aList.add(a);
        aList.add(a2);

        A a3 = aList.get(0);
        a3 = a2;


        for(A a4: aList) {
            System.out.println(a4);
        }


    }
}
