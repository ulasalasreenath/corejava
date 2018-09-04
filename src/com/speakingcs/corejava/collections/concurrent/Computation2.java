package com.speakingcs.corejava.collections.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Computation2 implements Runnable{
	
	public static int sum = 0;
	private CyclicBarrier barrier;
	
	public Computation2(CyclicBarrier barrier)
	{
		this.barrier = barrier;
	}
	
	public void run()
	{
		System.out.println("Is the barrier broken? " + barrier.isBroken());
		
		sum = 10+20;
		
		try
		{
			barrier.await();
			
			System.out.println("Number of parties waiting at the barrier at this point" + barrier.getNumberWaiting());
		} catch(InterruptedException | BrokenBarrierException e)
		{
			e.printStackTrace();
		}
	}

}
