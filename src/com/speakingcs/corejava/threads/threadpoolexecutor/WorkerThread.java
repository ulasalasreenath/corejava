package com.speakingcs.corejava.threads.threadpoolexecutor;

public class WorkerThread implements Runnable{

	private String command;
	
	public WorkerThread(String command)
	{
		this.command = command;
	}
	
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName() + " - Command = " +command);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " - End." );
	}
	
	public void processCommand()
	{
		try
		{
			Thread.sleep(5000);
		} catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
	
	@Override
	public String toString()
	{
		return command;
		
	}
	
}
