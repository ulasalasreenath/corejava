package org.speakingcs.designpatterns.singleton;

public class SingletonLazyDoubleChecking {

    private static volatile SingletonLazyDoubleChecking INSTANCE;

    private SingletonLazyDoubleChecking() {

    }

    public static SingletonLazyDoubleChecking getInstance() {
        if(INSTANCE == null) {
            synchronized (SingletonLazyDoubleChecking.class) {
                if(INSTANCE == null) {
                    INSTANCE = new SingletonLazyDoubleChecking();
                }
            }
        }
        return INSTANCE;
    }

}
