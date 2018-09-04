package com.speakingcs.corejava.threads;

public class EvenOddPrinterThread {

	public static void main(String[] args) {

		EvenOdd evenOdd = new EvenOdd();

		Thread oddThread = new Thread(new Runnable() {

			@Override
			public void run() {
				evenOdd.printOdd();
			}
			
		});
		
		oddThread.setName("Odd Thread");

		Thread evenThread = new Thread(new Runnable() {
			@Override
			public void run() {
				evenOdd.printEven();
			}
		});

		evenThread.setName("Even Thread");
		
		oddThread.start();
		evenThread.start();
	}
}

class EvenOdd {

	private boolean oddPrinted = false;

	private boolean getOddPrinted() {
		return oddPrinted;
	}

	private void setOddPrinted(boolean oddPrinted) {
		this.oddPrinted = oddPrinted;
	}

	public synchronized void printEven() {

		for (int i = 1; i <= 10; i++) {

			while(!getOddPrinted())
			{
				try
				{
					wait();
				} catch(InterruptedException ie)
				{
					ie.printStackTrace();
				}
			}
			
			if (!isOdd(i)) {
				System.out.println(Thread.currentThread().getName() + "-----" + i);
			}
			
			setOddPrinted(false);
			notifyAll();
		}
	}

	public synchronized void printOdd() {

		for (int i = 1; i <= 10; i++) {

			while (getOddPrinted()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (isOdd(i)) {
				System.out.println(Thread.currentThread().getName() + "-----" + i);
			}
			setOddPrinted(true);
			notifyAll();
		}
	}

	private boolean isOdd(int i) {
		return (i % 2 != 0);
	}

}
