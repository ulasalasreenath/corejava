package org.speakingcs.designpatterns.singleton;

public class SingletonEagerTest {

    public static void main(String[] args) {
        SingletonEager INSTANCE  = SingletonEager.getInstance();
        SingletonEager INSTANCE1 = SingletonEager.getInstance();

        System.out.println(INSTANCE == INSTANCE1);
    }
}
