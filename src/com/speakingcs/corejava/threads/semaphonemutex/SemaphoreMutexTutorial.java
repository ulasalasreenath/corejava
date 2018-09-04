package com.speakingcs.corejava.threads.semaphonemutex;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreMutexTutorial {

	static Object lock = new Object();
	static List<String> list = new LinkedList<String>();
	
	static Semaphore semaphore = new Semaphore(0);
	static Semaphore mutex = new Semaphore(1);
	
	static class Producer extends Thread{
		
		public void run()
		{
			int counter = 1;
			try{
				
				while(true)
				{
					String threadName = Thread.currentThread().getName() + counter++;
					mutex.acquire();
					
					list.add(threadName);
					System.out.println("Producer is producing new value: " + threadName);
					mutex.release();
					
					semaphore.release();
					Thread.sleep(500);
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	static class Consumer extends Thread
	{
		String consumerName;
		
		public Consumer(String name)
		{
			consumerName = name;
		}
		
		public void run()
		{
			try{
				while(true)
				{
					//acquire lock					
					semaphore.acquire();
					
					mutex.acquire();
					
					String result = "";
					for(String value: list)
					{
						result = value +",";
					}
					
					System.out.println(consumerName +" consumes value: " + result + "list.size():" + list.size() +"\n");
					mutex.release();
				}
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
