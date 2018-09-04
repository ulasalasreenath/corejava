package com.speakingcs.corejava.collections.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Tester implements Runnable{
	
	private CyclicBarrier barrier = new CyclicBarrier(3);
	
	public static void main(String[] args)
	{
		Tester test = new Tester();
		
		Thread t1 = new Thread(test);
		t1.start();
	}

	public void run()
	{
		System.out.println("Number of parties required to trip the barrier = " + barrier.getParties());
		
		System.out.println("Sum of product and sum = " + (Computation1.product + Computation2.sum));
		
		Computation1 comp1 = new Computation1(barrier);
		Computation2 comp2 = new Computation2(barrier);
		
		Thread t1 = new Thread(comp1);
		Thread t2 = new Thread(comp2);
		
		t1.start();
		t2.start();
		
		try
		{
			barrier.await();
		} catch(InterruptedException | BrokenBarrierException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Sum of product and sum = " + (Computation1.product + Computation2.sum));
		
		barrier.reset();
		
		System.out.println("Barrier reset is successful");
		
	}
	
	
}
