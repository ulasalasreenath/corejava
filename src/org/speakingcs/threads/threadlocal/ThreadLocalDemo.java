package org.speakingcs.threads.threadlocal;

import java.util.Random;

import com.speakingcs.corejava.threads.BusinessService;

public class ThreadLocalDemo extends Thread {

	public static void main(String[] args) {

		Thread threadOne = new ThreadLocalDemo();
		threadOne.start();

		Thread threadTwo = new ThreadLocalDemo();
		threadTwo.start();

	}

	public void run() {

		Context context = new Context();
		context.setTransactionId(getName());

		MyThreadLocal.set(context);
		MyThreadLocal.a = new Random().nextInt(100);

		System.out.println(MyThreadLocal.get().getTransactionId());
		System.out.println(MyThreadLocal.a);
		

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(MyThreadLocal.a);
		System.out.println(MyThreadLocal.get().getTransactionId());

	}

}
