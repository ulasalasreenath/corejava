package com.speakingcs.corejava.collections.concurrent;

import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
	
	public static void main(String[] args)
	{
		
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		
		list.add("abc");
		list.add("ade");
		list.add("acd");
		list.add("acc");
		
		for(String s: list)
		{
			list.set(0, "555");
			System.out.println(s);
			list.add("224");
			list.add("225");
		}

		Collections.sort(list);
		
		System.out.println(list);
	}

}
