package org.speakingcs.designpatterns.singleton;

public class SingletonLazySynchronized {

    private static SingletonLazySynchronized INSTANCE;

    private SingletonLazySynchronized() {

    }

    public static synchronized SingletonLazySynchronized getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SingletonLazySynchronized();
        }
        return INSTANCE;

    }

}
