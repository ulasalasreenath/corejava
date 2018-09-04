package com.speakingcs.corejava.threads.volatileTest;

public class StoppableTask extends Thread{
	
	private volatile boolean pleaseStop;
	
	public void run()
	{
		while(!pleaseStop)
		{
			System.out.println("Don't stop me");
			try
			{
				sleep(1000);
			} catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
		System.out.println(getName() +" stopped ");
	}
	
	public void tellMeToStop()
	{
		pleaseStop = true;
	}

}
