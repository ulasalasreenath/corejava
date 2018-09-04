package com.hackerearth.accolite;

public class XYZ2{

    void addTwo(int varM) {
        varM += 3;
    }

    public static void main(String[] args){
        int varM = 0;
        addTwo(varM++);
        System.out.println(varM);
    }

}