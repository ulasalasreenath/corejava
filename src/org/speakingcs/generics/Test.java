package org.speakingcs.generics;

public class Test<T1> {

	T1 obj;
	
	public Test(T1 obj)
	{
		this.obj = obj;
	}
	
	public T1 getObject()
	{
		return obj;
	}
	
	
	static <T> void genericDisplay(T element)
	{
		System.out.println(element.getClass().getName() + " = " + element);
	}
}
