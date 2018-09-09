package collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {

        Set<Pair> aSet = new HashSet<>();

        Pair p = new Pair(1, 2);
        Pair p2 = new Pair(1,2);
        Pair p3 = new Pair(1,2);
        Pair p4 = new Pair(1,2);
        Pair p5 = new Pair(1,2);
        System.out.println(p5.hashCode());
        Pair p6 = new Pair(2,1);
        System.out.println(p6.hashCode());
        Pair p7 = new Pair(2,3);

        aSet.add(p);
        aSet.add(p2);
        aSet.add(p3);
        aSet.add(p4);
        aSet.add(p5);
        aSet.add(p6);
        aSet.add(p7);

        for(Pair pair: aSet) {
            System.out.println(pair);
        }

    }


    static class Pair{
        int first = 0;
        int second = 0;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            return first + "-" + second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;

            if(first == pair.first && second == pair.second) {
                return true;
            }
            return first == pair.second &&
                    second == pair.first;
        }

        @Override
        public int hashCode() {

            //return Objects.hash(first, second);
            return first + second;
        }
    }
}
