package org.speakingcs.corejava.overloading;

public class OverloadingTest3 {

    public static void main(String[] args) {

    }


    // Start - same method name, different arguments, same return type
    public int a(int a1) {
        return a1;
    }

    public int a(long a2) {
        return 1;
    }

    public int a(byte a3) {
        return 1;
    }
    // End  - same method name, different arguments, same return type

    /**
     * Same method name, same arguments type, return types are different - ERROR
    public int b(int a1) {
        return a1;
    }

    public long b(int a1) {
        return 1;
    }
    **/



}
