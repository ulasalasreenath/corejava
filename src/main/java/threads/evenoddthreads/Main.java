package threads.evenoddthreads;

public class Main {

    static Boolean isOddPrinted = false;
    static String monitor = "";

    public static void main(String[] args) {

        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        new Thread(oddThread, "Odd Thread").start();
        new Thread(evenThread, "Even Thread").start();
    }
}
