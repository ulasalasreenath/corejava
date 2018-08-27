package statictests;

/**
 * This program will throw Stack overflow exception
 */
public class A {

    private A a = new A();
    private A a1 = new A();

    public static void main(String[] args) {
        System.out.println("Testing");
        A a = new A();
    }
}
