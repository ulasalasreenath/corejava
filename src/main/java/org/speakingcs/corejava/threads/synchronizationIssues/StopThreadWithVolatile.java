package org.speakingcs.corejava.threads.synchronizationIssues;

import java.util.concurrent.TimeUnit;

public class StopThreadWithVolatile {

    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(!stopRequested) {
                    i++;
                }
            }
        });

        TimeUnit.SECONDS.sleep(1);

        stopRequested = true;

    }
}
