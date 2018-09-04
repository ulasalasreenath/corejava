package com.speakingcs.corejava.threads.threadpool;

import java.util.concurrent.ThreadPoolExecutor;

public class MyMonitorThread implements Runnable {

	private ThreadPoolExecutor executor;
	private int seconds;
	private boolean run = true;

	public MyMonitorThread(ThreadPoolExecutor executor, int delay) {
		this.executor = executor;
		this.seconds = delay;
	}

	public void shutdown() {
		run = false;
	}

	public void run() {
		while (run) {
			String output = String.format(

					"[monitor] [%d/%d] Active: %d, Completed: %d" + ", isShutdown: %s, isTerminated: %s",
					executor.getPoolSize(), executor.getCorePoolSize(), executor.getActiveCount(),
					executor.getCompletedTaskCount(), executor.getTaskCount(), executor.isShutdown(),
					executor.isTerminated());
			
			System.out.println(output);
			
			try
			{
				Thread.sleep(seconds * 1000);
			} catch(InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}

}
