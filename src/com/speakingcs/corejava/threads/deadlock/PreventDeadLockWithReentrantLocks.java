package com.speakingcs.corejava.threads.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class PreventDeadLockWithReentrantLocks {

	public static void main(String[] args) {

		final ReentrantLock lockA = new ReentrantLock();
		final ReentrantLock lockB = new ReentrantLock();

		new Thread("Thread A") {
			public void run() {
				while(true)
				{
					try
					{
						System.out.println(this + "acquiring lockA");
						
						if(lockA.tryLock())
						{
							System.out.println(this + " acquired lockA");
							System.out.println(this + " acquiring lockB");
							
							if(lockB.tryLock()) {
								System.out.println(this + " acquired lockB");
							}
						}
					} finally
					{
						if(lockB.isHeldByCurrentThread()) lockB.unlock();
						if(lockA.isHeldByCurrentThread()) lockA.unlock();
					}
				}
			}
		}.start();

		new Thread("Thread B")
		{
			public void run()
			{
				while(true)
				{
					try
					{
						System.out.println(this + "acquiring lock B");
						
						if(lockB.tryLock())
						{
							System.out.println(this + " acquired lockB");
							System.out.println(this + " acquiring lockA");
							
							if(lockA.tryLock())
							{
								System.out.println(this + "acquired lockA");
							}
						}
						
						
					} finally{
						if(lockA.isHeldByCurrentThread())
						{
							lockA.unlock();
						}
						
						if(lockB.isHeldByCurrentThread())
						{
							lockB.unlock();
						}
					}
				}
			}
		}.start();
		
	}

}
