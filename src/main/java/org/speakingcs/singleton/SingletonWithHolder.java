package org.speakingcs.singleton;

public class SingletonWithHolder {

    private SingletonWithHolder() {

    }

    private static class Holder {
        private static final SingletonWithHolder INSTANCE = new SingletonWithHolder(); // lazy initialization
    }

    public static SingletonWithHolder getInstance() {
        return Holder.INSTANCE;
    }


}
