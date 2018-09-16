package threads.evenoddthreads;

public class OddThread implements Runnable {


    @Override
    public void run() {

        int counter = 1;
        while(true && counter <= 20) {
            synchronized (Main.monitor) {

                if(!Main.isOddPrinted) {
                    System.out.println(Thread.currentThread().getName() + "-" + counter);
                    counter += 2;
                    Main.isOddPrinted = true;
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
