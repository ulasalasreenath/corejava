package org.speakingcs.corejava.overloading;

public class OverloadingTest {

    public static void main(String[] args) {


        print(5);

        byte b = 10;
        print(b);

    }

    static void print(Integer i) {
        System.out.println("It's integer " + i);
    }

    static void print(Long l) {
        System.out.println("It's long " + l);
    }

    static void print(byte c) {
        System.out.println("It's byte " + c);
    }
}
