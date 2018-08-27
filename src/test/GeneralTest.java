package test;

public class GeneralTest {

    static String test = "test";

    public static void main(String[] args) {

    }

    /**
     * you can access static variables from non static context
     */
    public void testStatic() {
        System.out.println(test);
    }
}
