package com.hackerearth.accolite;

class ABC6 { 

    public static void main(String args[]) { 
        String a1 = "Stop"; 
        StringBuffer ab = new StringBuffer(a1); 

        ab.reverse(); 
        a1.concat(ab.toString()); 

        System.out.println(a1 + ab + a1.length() + ab.length()); 
    }
}