package statictests;

/**
 * when ever class is loaded, first static variables will be initialized
 * when ever class is initialized, then non static variables will be initialized
 */
public class B {

    static {
        Integer c = new Integer(300);
        Integer d = new Integer(400);
    }

    private static Integer a = new Integer(100);
    private static Long b = new Long(200);

    {
        Integer e = new Integer(500);
        Integer f = new Integer(600);
    }

    private Integer g = new Integer(700);
    private Integer h = new Integer(800);

    public static void main(String[] args) {
        System.out.println("testing");
        new B();
    }
}
