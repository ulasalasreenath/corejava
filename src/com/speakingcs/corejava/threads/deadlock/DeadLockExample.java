package com.speakingcs.corejava.threads.deadlock;

public class DeadLockExample {

	public static void main(String[] args) {

		DeadLockExample deadLockExample = new DeadLockExample();

		final A a = deadLockExample.new A();
		final B b = deadLockExample.new B();

		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				synchronized (a) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}

					System.out.println("About to acquire b Waiting ......");
					synchronized (b) {
						System.out.println("Lock is acquired.....");
						System.out.println("In Runnable 1");
					}
				}
			}
		};

		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				synchronized (b) {
					synchronized (a) {
						System.out.println("In Runnable 2");
					}
				}
			}
		};

		new Thread(runnable1).start();
		new Thread(runnable2).start();

	}

	private class A {
		private int i = 10;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

	}

	private class B {
		private int i = 20;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
	}

}
