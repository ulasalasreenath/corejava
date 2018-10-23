package org.speakingcs.designpatterns.singleton;

public class SingletonLazyTest {

    public static void main(String[] args) {

        SingletonLazy INSTANCE1 = SingletonLazy.getInstance();
        SingletonLazy INSTANCE2 = SingletonLazy.getInstance();

        System.out.println(INSTANCE1 == INSTANCE2);


    }
}
