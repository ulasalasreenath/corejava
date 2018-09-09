package org.speakingcs.corejava.polymorphism;

import java.io.FileNotFoundException;

public class A {
	
	public void print()
	{
		System.out.println("from A");
	}
	
	private void print2()
	{
		System.out.println("from private method print2() of A");
	}
	
	private int print2(int a, int b)
	{
		return 0;
	}

	public static void print3()
	{
		System.out.println("from static method print3() of A");
	}
	
	void printDefault()
	{
		System.out.println("printDefault() from a");
	}
	
	public A give() throws FileNotFoundException
	{
		return new A();
	}
	
	public final void print4()
	{
		System.out.println("print 4");
	}
}
