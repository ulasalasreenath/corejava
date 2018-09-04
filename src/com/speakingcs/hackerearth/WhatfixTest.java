package com.speakingcs.hackerearth;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WhatfixTest {

	public static Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

	public static void main(String[] arg) {
		WhatfixTest test = new WhatfixTest();
		test.processData();
	}

	private void processData() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ExecutorService executorService = Executors.newFixedThreadPool(t);
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			Integer[] arr = new Integer[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			executorService.execute(new SubtaskThread(i, arr));
		}
		sc.close();
		executorService.shutdown();

		try {
			executorService.awaitTermination(1000, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<Integer, Integer> sortedMap = new TreeMap<>(map);
		for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry.getValue());
		}

	}
}



class SubtaskThread implements Runnable {
	Integer[] arr = null;
	int index;
	int maxVal;

	int diff = -1;
	int size = -1;

	SubtaskThread(int index, Integer[] arr) {
		this.index = index;
		this.arr = arr;
	}

	@Override
	public void run() {
		for (Integer val : arr) {
			maxVal = maxVal | val;
		}
		List<List<Integer>> powerSet = new LinkedList<List<Integer>>();
		for (int i = 2; i <= arr.length; i++)
			powerSet.addAll(combination(Arrays.asList(arr), i));

		//System.out.println(powerSet);
		//System.out.println("Size:" + powerSet.size());

		for (List<Integer> list : powerSet) {
			calculateOR(list);
		}
		WhatfixTest.map.put(index, size);
	}

	private void calculateOR(List<Integer> list) {
		Integer tmpOrVal = 0;
		for (Integer val : list) {
			tmpOrVal = tmpOrVal | val;
		}
		int tmpDiff = tmpOrVal - maxVal;
		if (tmpDiff < diff && size < list.size()) {
			diff = tmpDiff;
			size = list.size();
		}
	}

	public static <T> List<List<T>> combination(List<T> values, int size) {

		if (0 == size) {
			return Collections.singletonList(Collections.<T> emptyList());
		}

		if (values.isEmpty()) {
			return Collections.emptyList();
		}

		List<List<T>> combination = new LinkedList<List<T>>();

		T actual = values.iterator().next();

		List<T> subSet = new LinkedList<T>(values);
		subSet.remove(actual);

		List<List<T>> subSetCombination = combination(subSet, size - 1);

		for (List<T> set : subSetCombination) {
			List<T> newSet = new LinkedList<T>(set);
			newSet.add(0, actual);
			combination.add(newSet);
		}

		combination.addAll(combination(subSet, size));

		return combination;
	}

}