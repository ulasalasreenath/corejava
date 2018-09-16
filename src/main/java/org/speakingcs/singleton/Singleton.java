package org.speakingcs.singleton;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    private static Singleton INSTANCE = new Singleton();

    private Singleton() {
        if(INSTANCE != null) {
            throw new RuntimeException("Illegal way of instance creation, call getInstance() only");
        }
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        if(INSTANCE != null) {
            throw new CloneNotSupportedException("Cannot clone Singleton instance");
        }
        return super.clone();
    }

    private Object readResolve() {
        return INSTANCE;
    }

}
