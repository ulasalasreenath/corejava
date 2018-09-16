package org.speakingcs.corejava.threads.phaser;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable{

    /**
     * folder in which search operation will begin
     */
    private String initPath;

    /**
     * file extension
     */
    private String end;

    /**
     * to store full path of the files
     */
    private List<String> results;

    /**
     * to control the synchronization of the different
     * phases of the task
     */
    private Phaser phaser;

    public FileSearch(String initPath, String end, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        results = new ArrayList<>();
    }

    @Override
    public void run() {

        /**
         * wait until all the org.speakingcs.threads have been created
         */
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: Starting.\n", Thread.currentThread().getName());
        File file = new File(initPath);
        if(file.isDirectory()) {
            directoryProcess(file);
        }

        if(!checkResults()) {
            return;
        }

        filterResults();

        if(!checkResults()) {
            return;
        }

        showInfo();
        phaser.arriveAndDeregister();
        System.out.printf("%s: work completed \n", Thread.currentThread().getName());

    }

    private void directoryProcess(File file) {

        File[] list = file.listFiles();
        if(list != null) {

            for(int i = 0; i < list.length; i++) {

                if(list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }

            }
        }

    }

    private void fileProcess(File file) {
        if(file.getName().endsWith(end)) {
            results.add(file.getAbsolutePath());
        }
    }

    private void filterResults() {
        List<String> newResults = new ArrayList<>();
        long actualDate = new Date().getTime();

        for(int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            long fileDate = file.lastModified();

            if(actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                newResults.add(results.get(i));
            }
        }
        results = newResults;
    }

    private boolean checkResults() {
        if(results.isEmpty()) {
            System.out.printf("%s: Phase %d: 0 results.\n", Thread.currentThread().getName(), phaser.getParent());
            System.out.printf("%s: Phase %d: End.\n", Thread.currentThread().getName(), phaser.getParent());
            phaser.arriveAndDeregister();
            return false;
        } else {
            System.out.printf("%s: Phase %d: %d results \n", Thread.currentThread().getName(), phaser.getPhase(), results.size());
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }

    private void showInfo() {
        for(int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }

        phaser.arriveAndAwaitAdvance();
    }
}
