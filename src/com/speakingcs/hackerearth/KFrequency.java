package com.speakingcs.hackerearth;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class KFrequency {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i = 0; i < N ; i++)
		{
			String str = sc.next();
			int kth = sc.nextInt();
			getKthFrequencyElement(str, kth);
			//System.out.println(kthfrequency);
		}
	}

	private static void getKthFrequencyElement(String str, int kth) {
		TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>();
		
		char[] charArr = str.toCharArray();
		for(int i = 0; i < charArr.length; i++)
		{
			char c = charArr[i];
			
			if(treeMap.containsKey(c))
			{
				Integer value = treeMap.get(c);
				value++;
				treeMap.put(c, value);
			} else
			{
				treeMap.put(c, 1);
			}
		}
		
		//TreeMap<Character, Integer> newMap = sortTheMap(treeMap);
		TreeMap<Integer, TreeSet<Character>> countMap = new TreeMap<Integer, TreeSet<Character>>(new Comparator<Integer>()
				{
					@Override
					public int compare(Integer i1, Integer i2) {
						int result = i2.compareTo(i1);
						return result;
					}
				});

		int i = 0;
		
		Set<Entry<Character, Integer>> entrySet = treeMap.entrySet();
		
		for(Entry<Character,Integer> anEntry : entrySet)
		{
			Character key = anEntry.getKey();
			Integer count = anEntry.getValue();
			
			if(countMap.containsKey(Integer.valueOf(count)))
			{
				countMap.get(count).add(key);
			}else
			{
				TreeSet<Character> value = new TreeSet<Character>();
				value.add(key);
				countMap.put(count, value);
			}
		}
		
		Set<Entry<Integer, TreeSet<Character>>> entrySet2 = countMap.entrySet();
		
		for(Entry<Integer,TreeSet<Character>> anEntry : entrySet2)
		{
			i++;
			if(i == kth)
			{
				System.out.println(anEntry.getValue().iterator().next());
				return;
			}
			
		}
		System.out.println(-1);
	}
}
