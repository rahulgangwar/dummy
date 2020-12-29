package jcr.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Exercises {
    public static void main(String[] args) {
        groupListCount(Arrays.asList("apple", "apple", "orange", "grapes"));
    }

    private static void groupListCount(List<String> data) {
        Map<String, Long> map =
                data.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println("Group list by count : " + map);
    }
}
