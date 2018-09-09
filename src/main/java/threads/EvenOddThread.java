package threads;

import java.util.Objects;

public class EvenOddThread {

    private boolean isOddPrinted = false;
    private int counter = 1;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvenOddThread that = (EvenOddThread) o;
        return counter == that.counter &&
                counter1 == that.counter1;
    }

    @Override
    public int hashCode() {

        return Objects.hash(counter, counter1);
    }

    private int counter1 = 1;

    public static void main(String[] args) {

        EvenOddThread evenOddThread = new EvenOddThread();
        Thread evenThread = new Thread(() -> {evenOddThread.printEven();}, "Even Thread");
        Thread oddThread = new Thread(() -> {evenOddThread.printOdd();}, "Odd Thread");
        evenThread.start();
        oddThread.start();
    }


    public synchronized void printEven() {

       while(true && counter <= 10) {
           if(isOddPrinted) {
               System.out.println(Thread.currentThread().getName() + "-" + counter);
               counter++;
               isOddPrinted = false;
               notify();
           } else {
               try {
                   wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }

    }

    public synchronized void printOdd() {
        while(true && counter <= 10) {
            if(!isOddPrinted) {
                System.out.println(Thread.currentThread().getName() + "-" + counter);
                counter++;
                isOddPrinted = true;
                notify();
            } else
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
