package overloading;

public class OverloadingTest {

    public static void main(String[] args) {


        print(5);

    }

    static void print(Integer i) {
        System.out.println("It's integer " + i);
    }

    static void print(Long l) {
        System.out.println("It's long " + l);
    }
}
