package com.speakingcs.corejava.collections.concurrent;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
	
	public static void main(String[] args)
	{
		ConcurrentHashMap<String,String> map = new ConcurrentHashMap<String,String>();
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		map2.put(null, null);
		
		//map.put(null, null);
	}

}
