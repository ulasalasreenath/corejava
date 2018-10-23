package threads;

public class ThreadTest extends Thread{

    public void run() {
        String o = "";
        synchronized (o) {
            try {
                wait();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new ThreadTest().start();
    }
}
