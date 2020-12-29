package exercises.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Arrange given numbers to form the biggest number. Input- List of numbers : {1, 34, 3, 98, 9, 76,
 * 45, 4} Output : 998764543431
 */
public class MaxNumberByRearrangingList {
    public static void main(String[] args) {
        int[] data = {1, 34, 3, 98, 9, 76, 45, 4};
        List<Integer> list = Arrays.stream(data).boxed().collect(Collectors.toList());

        String finalResult =
                list.stream()
                        .sorted(
                                (x, y) -> {
                                    String s1 = x.toString().concat(y.toString());
                                    String s2 = y.toString().concat(x.toString());
                                    return s2.compareTo(s1);
                                })
                        .map(Object::toString)
                        .collect(Collectors.joining("", "", ""));

        System.out.println(finalResult);
    }
}
