package org.speakingcs.corejava.polymorphism;

import java.io.IOException;

public class Overloading {
	
	public static void function(int a, int b)
	{
		System.out.println("ints a =" +a +" b = " + b);
	}
	
	public static void function(long a, long b)
	{
		System.out.println("longs a =" +a +" b = " + b);
	}

	public static void function(byte a, byte b) {
		System.out.println("bytes a = " + a + " b = " + b);
	}

	public void m1(Object o) {
        System.out.println(o.toString());
    }

    public void m1(Double d) {
        System.out.println(d.toString());
    }

	
	public static void main(String[] args) {
		//function(5,6);
		function(5, 6);
		function(5l, 6l);
		byte a = 10, b = 20;
		function(a, b);
		Overloading ol = null;
		ol.function(55, 65);

		ol = new Overloading();
		ol.m1(new Double(5.6));
		Object o = new Object();
		ol.m1(o);
		Object o1 = new Double(5.6);
		ol.m1(o1);
	}

}
