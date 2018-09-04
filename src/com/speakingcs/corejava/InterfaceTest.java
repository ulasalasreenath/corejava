package com.speakingcs.corejava;

import java.util.ArrayList;
import java.util.List;

public class InterfaceTest implements I1, I2{
	
	
	public static void main(String[] args)
	{
		I1 it = new InterfaceTest();
		System.out.println(it.a);
		
		
		List<String> strings = new ArrayList<String>();
		List<Object> objects = new ArrayList<Object>();
		
		
		Object[] objArray = new Object[5];
		String[] strArray = new String[5];
		
		objArray = strArray;
		
		
		A a = new A();
		B b = new B();
		A a1 = new B();
		
		a = b;
		b = (B) a1;
		
	}

}
