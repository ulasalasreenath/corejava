package puzzles;

public class InheritanceWithStatic {

    public static void main(String[] args) {

        Author a = new Author();
        a.write();

    }
}

class Writer {
    public static void write() {
        System.out.println("Writing ...");
    }
}

class Author extends Writer{

}