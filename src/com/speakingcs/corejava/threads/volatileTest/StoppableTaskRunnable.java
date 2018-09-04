package com.speakingcs.corejava.threads.volatileTest;

public class StoppableTaskRunnable implements Runnable{

	private volatile boolean stop = false;
	
	public void setStop()
	{
		stop = true;
	}
	
	public void run() {

		while(!stop)
		{
			System.out.println("thread is running");
		}
		System.out.println("thread is stopped");
	}

}
