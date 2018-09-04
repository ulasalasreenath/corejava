package org.speakingcs.corejava.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		A a = new A();
		A b = new B();
		B c = new B();
		
		print(a);
		print(b);
		print(c);
		
		a.print3();
		b.print3();
		c.print2();
		c.print3();
		
		A[] as = new A[10];
		B[] bs = new B[10];
		
		as = bs;
		
		List<? extends Integer> intList = new ArrayList<>();
		
		
		List<? extends Number> numList = new ArrayList<>();
		
		
	}
	
	public static void print(A a)
	{
		a.print();
	}
	
	public static void print(B b)
	{
		b.print();
	}

}
