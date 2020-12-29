package exercises.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Find out the number of pair from given integer array whose sum is equal to a given number. */
public class SubSetWithSumN {
    private static Set<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 10, 20, 5, 5, 5, 5, 10, 15};
        printpairs(data, 20);
    }

    private static void findSubset(int[] data, int n, int i, List<Integer> s) {
        if (sum(s) == n) {
            set.add(s);
            return;
        }
        if (i >= data.length) return;

        int current = data[i];
        i++;
        s.add(current);
        findSubset(data, n, i, s);
        findSubset(data, n, i, new ArrayList<>());
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    /** print pairs with sum equal to N */
    private static void printpairs(int arr[], int sum) {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int value : arr) {
            int temp = sum - value;
            if (s.contains(temp)) {
                System.out.println(value + "," + temp);
            }
            s.add(value);
            System.out.println("S : " + s);
        }
    }
}
