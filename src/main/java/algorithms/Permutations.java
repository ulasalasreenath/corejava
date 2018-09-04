package algorithms;

public class Permutations {

    public static void main(String[] args) {
        permute("abc");
    }

    private static void permute(String str) {
        permute("", str);
    }

    private static void permute(String prefix, String str) {

        if(str.length() == 0) {
            System.out.println(prefix);
        }

        for(int i = 0; i < str.length(); i++) {
            permute(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1, str.length()));
        }

    }

}
