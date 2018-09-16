package test;

public class GeneralTest {

    static String test = "test";

    public static void main(String[] args) {
        A a = new A();
    }

    /**
     * you can access static variables from non static context
     */
    public void testStatic() {
        System.out.println(test);
    }
}
