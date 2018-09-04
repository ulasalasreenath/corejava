package com.speakingcs.corejava.threads.volatileTest;

public class ThreadMain {
	
	public static void main(String[] args)
	{
		
		/*StoppableTask st1 = new StoppableTask();
		
		Thread t = new Thread(st1);
		t.run();*/
		/*System.out.println("Before starting stoppable task");
		
		StoppableTask st = new StoppableTask();
		st.run();*/
		
		StoppableTaskRunnable str = new StoppableTaskRunnable();
		new Thread(str).start();
		str.setStop();
		
		
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		//st.tellMeToStop();
		//st1.tellMeToStop();
		
		System.out.println("after stoppable task");
		
	}

}
