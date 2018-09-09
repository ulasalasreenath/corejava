package org.speakingcs.generics;

public class NaturalNumber<T extends Integer>{

	public boolean isEven(T a)
	{
		return a.intValue() %2 == 0;
	}
	
}
