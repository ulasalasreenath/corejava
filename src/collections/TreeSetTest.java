package collections;

import java.util.TreeSet;

public class TreeSetTest {
	
	public static void main(String[] args)
	{
		TreeSet<A> ts = new TreeSet<A>();
		ts.add(new A());
		ts.add(new A());
		ts.add(new A());
		
		for(A a: ts)
		{
			System.out.println(a.i);
		}
		
	}
	
	
}


class A
{
	int i = 1;
}