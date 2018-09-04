package com.speakingcs.corejava.collections.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Computation1 implements Runnable{

	public static int product = 0;
	private CyclicBarrier barrier;
	
	public Computation1(CyclicBarrier barrier)
	{
		this.barrier = barrier;
	}
	
	public void run() {
		
		product = 2*3;
		
		try
		{
			barrier.await();
		} catch(BrokenBarrierException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
