package org.speakingcs.corejava.collections;

import java.util.PriorityQueue;

public class MaximizeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { -5, -100, -6, -500, -8 };
		int k = 1;

		System.out.println(getMaxSum(a, k));

	}

	private static int getMaxSum(int[] a, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i : a) {
			pq.add(i);
		}
		
		while(k-- > 0)
		{
			int temp = pq.poll();
			temp *= -1;
			pq.add(temp);
		}
		
		int sum = 0;
		for(int x: pq)
		{
			sum+= x;
		}
		
		return sum;

	}

}
