package exercises.algos;

import java.util.ArrayList;
import java.util.List;

/** Used to find subarray with max sum It */
public class KadanesAlgo {

    private static List<List<Integer>> subArrays = new ArrayList<>();

    public static void main(String[] args) {
        int[] data = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        List<Integer> subarray = new ArrayList<>();
        subarray.add(data[0]);
        findSubArrayWithMaxSum(data, 1, subarray, data[0]);
        System.out.println(subArrays);
    }

    private static void findSubArrayWithMaxSum(
            int[] data, int i, List<Integer> subarray, int maxSum) {
        if (i == data.length) {
            System.out.println(subarray);
        } else {
            int element = data[i];
            int tempSum = element + maxSum;
            if (tempSum >= maxSum) {
                subarray.add(element);
                maxSum += element;
            } else {
                subArrays.add(subarray);
                maxSum = element;
                subarray.clear();
                subarray.add(element);
            }
            i++;
            System.out.println(
                    String.format(
                            "Subarray: %s, maxSum: %s, tempSum: %s, element: %s",
                            subarray, maxSum, tempSum, element));
            findSubArrayWithMaxSum(data, i, subarray, maxSum);
        }
    }
}
