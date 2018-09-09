package org.speakingcs.corejava.polymorphism;

public class InnerClasses {


	static class A
	{
		public A()
		{
			System.out.println("from static class A constructor");
		}
	}
	
	public static void main(String[] args)
	{
		A a = new A();
		
	}
	
	
}

