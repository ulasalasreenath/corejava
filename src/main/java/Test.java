import java.util.*;

public class Test {


    public static void main(String[] args) {

        /*int i = 2;
        System.out.println(i << 2);
        System.out.println(i >> 2);

        System.out.println(-1 >>> 3);
        System.out.println( -1 >> 3);

        System.out.println("4 ^ 2 " + (6 ^2));
*/
        /*Integer[] i = new Integer[16];

        for(int j = 0; j < 16; j++) {
            i[j] = j * 500;
        }

        *//*for(Integer i1 : i) {

            int h = i1.hashCode();

            System.out.println(i1 + " " + (h ^ (h >>> 16)));


        }*//*

        for(Integer i1: i) {
            System.out.println( 15 & i1.hashCode());
        }*/

       /* Map<String, String> aMap = new HashMap<>();
        aMap.put(null, null);
        aMap.put(null, "1");

        System.out.println(aMap.get(null));*/

        System.out.println(4 >>> 1);

        class A {
            String str = "abc";

            @Override
            public int hashCode() {
                return str.hashCode();
            }

            @Override
            public boolean equals(Object that) {
                return false;
            }
        }

        Set<A> aSet = new HashSet<>();
        aSet.add(new A());
        aSet.add(new A());
        aSet.add(new A());

        System.out.println(aSet.size());


    }
}
