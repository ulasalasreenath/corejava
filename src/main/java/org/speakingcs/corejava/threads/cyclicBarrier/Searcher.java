package org.speakingcs.corejava.threads.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Searcher implements Runnable{

    private int firstRow;
    private int lastRow;

    private MatrixMock mock;
    private Results results;
    private int number;
    private final CyclicBarrier barrier;

    public Searcher(int firtRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
        this.firstRow = firtRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }


    @Override
    public void run() {
        int counter;
        System.out.printf("%s: Processing lines from %d to %d \n", Thread.currentThread().getName(), firstRow, lastRow);

        /**
         * process all the rows assigned to this thread.
         * for each row, count the number of occurrences of the
         * number and store this number in the corresponding
         * position of the Result object.
         */
        for(int i = firstRow; i < lastRow; i++) {
            int[] row = mock.getRow(i);
            counter = 0;

            for(int j = 0; j < row.length; j++) {
                if(row[j] == number) {
                    counter ++;
                }
            }
            results.setData(i, counter);
        }

        System.out.printf("%s: Lines processed \n" , Thread.currentThread().getName());

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
