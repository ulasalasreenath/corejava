package org.speakingcs.designpatterns.singleton;

public class SingletonLazySynchronizedTest {


    public static void main(String[] args) {

        new Thread(() -> {
            SingletonLazySynchronized INSTANCE = SingletonLazySynchronized.getInstance();
            System.out.println(INSTANCE);
        }).start();

        new Thread(() -> {
            SingletonLazySynchronized INSTANCE = SingletonLazySynchronized.getInstance();
            System.out.println(INSTANCE);
        }).start();


    }

}
