package jcr.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 1) Checks sorting on uncomparable class 2) Checks sorting on uncomparable class using comparator
 * 3) Checks sorting of a hybrid list
 */
public class ComparatorComparable {
    public static void main(String[] args) {
        sortListOfNonComparables();
        sortListOfNonComparablesUsingComparator();
        sortHybridList();
    }

    private static void sortListOfNonComparables() {
        System.out.println("ComparatorComparable.sortListOfNonComparables");
        try {
            List list = new ArrayList();
            list.add(new NonComparable(1, "rahul", 32));
            list.add(new NonComparable(1, "babu", 38));

            System.out.println("Unsorted list : " + list);
            Collections.sort(list); // throws ClassCastException
            System.out.println("Sorted list : " + list);
        } catch (final ClassCastException cce) {
            System.out.println("Exception : " + cce.getMessage());
        }
    }

    private static void sortListOfNonComparablesUsingComparator() {
        System.out.println("ComparatorComparable.sortListOfNonComparablesUsingComparator");
        try {
            List list = new ArrayList();
            list.add(new NonComparable(1, "rahul", 32));
            list.add(new NonComparable(1, "babu", 38));

            System.out.println("Unsorted list : " + list);
            Collections.sort(list, new RollNoComparator()); // throws ClassCastException
            System.out.println("Sorted list : " + list);
        } catch (final ClassCastException cce) {
            System.out.println("Exception : " + cce.getMessage());
        }
    }

    private static void sortHybridList() {
        System.out.println("ComparatorComparable.sortHybridList");
        try {
            List hybridList = new ArrayList();
            hybridList.add(new Student(1, "rahul", 32));
            hybridList.add(new Employee(1, "babu", 38));

            System.out.println("Unsorted list : " + hybridList);
            Collections.sort(hybridList); // throws ClassCastException
            System.out.println("Sorted list : " + hybridList);
        } catch (ClassCastException cce) {
            System.out.println("Exception : " + cce.getMessage());
        }
    }

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class Student implements Comparable<Student> {
        int rollno;
        String name;
        int age;

        @Override
        public int compareTo(Student s2) {
            return Integer.compare(this.age, s2.age);
        }
    }

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class Employee implements Comparable<Employee> {
        int rollno;
        String name;
        int age;

        @Override
        public int compareTo(Employee employee) {
            return Integer.compare(this.age, employee.age);
        }
    }

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class NonComparable {
        int rollno;
        String name;
        int age;
    }

    private static class RollNoComparator implements Comparator<NonComparable> {
        @Override
        public int compare(NonComparable s1, NonComparable s2) {
            return Integer.compare(s1.rollno, s2.rollno);
        }
    }
}
