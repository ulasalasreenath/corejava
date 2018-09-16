package threads;

public class NotifyTest extends Thread {

    public void run() {
        notify();
        notify();
    }

    public static void main(String[] args) {
        new Thread(new NotifyTest()).start();
    }
}
