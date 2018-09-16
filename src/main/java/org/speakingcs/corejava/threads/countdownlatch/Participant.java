package org.speakingcs.corejava.threads.countdownlatch;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {

    private Videoconference videoconference;
    private String name;


    public Participant(Videoconference videoconference, String name) {
        this.videoconference = videoconference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random()*10);
        try{
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        videoconference.arrive(name);


    }
}
