package com.speakingcs.corejava.threads.producerconsumer;

import java.util.LinkedList;

public class ThreadExample {

	public static void main(String[] args) {

		ProducerConsumer pc = new ProducerConsumer();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {

				try
				{
					pc.consume();
				} catch(InterruptedException ie)
				{
					ie.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}

class ProducerConsumer {

	LinkedList<Integer> list = new LinkedList<Integer>();

	int capacity = 2;

	public synchronized void produce() throws InterruptedException {
		int value = 0;

		while (true) {
			while (list.size() == capacity) {
				wait();
			}

			System.out.println("Producer produced-" + value);

			list.add(value++);

			notify();

			Thread.sleep(1000);
		}
	}

	public synchronized void consume() throws InterruptedException {

		while (true) {

			while (list.size() == 0) {
				wait();
			}

			int val = list.removeFirst();

			System.out.println("Consumer consumed " + val);

			notify();

			Thread.sleep(1000);

		}

	}

}