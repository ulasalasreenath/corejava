package org.speakingcs.corejava.collections;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueExample {

	public static void main(String[] args) {
		
		Queue<Integer> integerPriorityQueue = new PriorityQueue<>(10);
		
		Random rand = new Random();
		
		for(int i = 0; i < 10; i++)
		{
			integerPriorityQueue.add(new Integer(rand.nextInt(100)));
		}
		
		for(int i = 0; i < 10; i++)
		{
			Integer in = integerPriorityQueue.poll();
			System.out.println("Processing integer " + in);
		}
	}
}
