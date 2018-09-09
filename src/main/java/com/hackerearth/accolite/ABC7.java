package com.hackerearth.accolite;

import java.util.*;

class ABC7 {

    public static void main(String args[]) throws Exception {
        byte a = 4;
        byte b = 6;
        System.out.print((b%a) + ", ");
        System.out.println(b == ( (b/a)*a + (b%a) ));
    }
}