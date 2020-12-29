package exercises.arrays;

public class SmallestInSortedRotatedArray {
    public static void main(String[] args) {
        int[] input = {19, 20, 3, 10, 11, 15, 17, 18};
        System.out.println(input[find(input, 0, input.length - 1)]);
    }

    private static int find(int[] data, int start, int end) {
        if (start < end) {
            int mid = start + end / 2;
            if (mid == 0 || (data[mid] < data[mid - 1]) && data[mid] <= data[mid + 1]) return mid;
            else if (data[mid] > data[end]) return find(data, mid + 1, end);
            else return find(data, start, mid - 1);
        }
        return start;
    }
}
