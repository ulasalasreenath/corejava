package org.speakingcs.accessspecifiers;

public class PrivateTest {


    static class A {
        private int a = 5;

        static {
            int b = 6;
        }

    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.a);
        B b = new B();


    }
}

class B {
    private int b = 5;

}

