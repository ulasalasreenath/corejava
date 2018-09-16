package org.speakingcs.corejava.threads.phaser2;

import java.util.concurrent.Phaser;

public class MyPhaser extends Phaser{

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                return studentsArrived();
            case 1:
                return finishFirstExcercise();
            case 2:
                return finishSecondExcercise();
            case 3:
                return finishExam();
            default:
                return true;
        }
    }

    private boolean finishExam() {

        System.out.printf("Phaser: All the students have finished the exam.\n");
        System.out.printf("Phaser: Thank you for your time.\n");
        return true;
    }

    private boolean finishSecondExcercise() {
        System.out.printf("Phaser: All the students have finished the second exercise.\n");
        System.out.printf("Phaser: It's time for the third one.\n");
        return false;
    }

    private boolean finishFirstExcercise() {
        System.out.printf("Phaser: All the students have finished the first exercise.\n");
        System.out.printf("Phaser: It's time for the second one.\n");
        return false;
    }

    private boolean studentsArrived() {
        System.out.printf("Phaser: The exams are going to start. The students are ready \n");
        System.out.printf("Phaser: we have %d students.\n", getRegisteredParties());
        return false;

    }

}
