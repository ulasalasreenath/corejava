package org.speakingcs.corejava.finaltests;

import java.util.HashSet;
import java.util.TreeSet;

public class ABC extends FinalTest{

	public static void m1()
	{
		//ABC.main(null);
		
		TreeSet<ABC> aTreeSet = new TreeSet<ABC>();
		HashSet<String> aHashSet = new HashSet<String>();
		aTreeSet.add(new ABC());
		aHashSet.add(null);
		
	}
	
	public static void main(String[] args) {
		m1();
	}
}
