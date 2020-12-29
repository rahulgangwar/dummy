package jcr.collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    private static class A {
        private int id;

        A(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            A a = (A) o;

            return id == a.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    public static void main(String[] args) {
        Set<A> set = new HashSet<>();
        set.add(new A(1));
        set.add(new A(1));
        set.add(new A(1));
        System.out.println("Size : " + set.size());
    }
}
