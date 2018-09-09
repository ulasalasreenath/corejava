package org.speakingcs.corejava.polymorphism;

import java.io.IOException;

public class B extends A{

	@Override
	public void print()
	{
		System.out.println("From Class B");
	}
	
	public void print2()
	{
		System.out.println("From Class B - print2()");
	}
	
	public static void print3()
	{
		System.out.println("From Class B - print3()");
	}
	
	@Override
	public B give()
	{
		return new B();
	}
	
}
