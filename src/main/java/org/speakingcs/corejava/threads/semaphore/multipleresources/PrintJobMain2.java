package org.speakingcs.corejava.threads.semaphore.multipleresources;

import org.speakingcs.corejava.threads.semaphore.multipleresources.PrintJob;

public class PrintJobMain2 {


    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Thread[] threads = new Thread[10];
        for(int i = 0; i < 10; i++) {
            threads[i] = new Thread(new PrintJob(printQueue), "Thread "+(i+1));
        }

        for(int i = 0; i< 10; i++) {
            threads[i].start();
        }


    }
}
