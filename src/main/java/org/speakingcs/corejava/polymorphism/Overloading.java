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
	
	public static void main(String[] args) {
		//function(5,6);
		function(5, 6);
	}

}
