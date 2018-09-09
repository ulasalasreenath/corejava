package org.speakingcs.corejava.threads.semaphore;

import java.util.concurrent.Semaphore;

public class PrintQueue {

    private final Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    /**
     * simulates printing of a document
     * @param document
     */
    public void printJob(Object document) {
        /**
         * acquire semaphore first
         */
        try {
            semaphore.acquire();
            /**
             * implement simulation behavior
             */

            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds \n", Thread.currentThread().getName(), duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

}
