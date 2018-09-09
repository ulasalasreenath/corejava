package threads.evenoddthreads;

public class EvenThread implements Runnable {


    @Override
    public void run() {

        int counter = 2;
        while(true && counter <= 20) {
            synchronized (Main.monitor) {
                if (Main.isOddPrinted) {
                    System.out.println(Thread.currentThread().getName() + "-" + counter);
                    counter += 2;
                    Main.isOddPrinted = false;
                    Main.monitor.notify();
                } else {
                    try {
                        Main.monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }


}
