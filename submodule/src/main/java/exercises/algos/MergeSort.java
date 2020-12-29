package exercises.algos;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = {1, 10, 99, 3, 2, 5, 0};
        for (int x : sort(a, 0, a.length - 1)) {
            System.out.println(x);
        }
    }

    private static int[] sort(int[] data, int start, int end) {
        if (start == end) return new int[] {data[start]};
        int mid = start + (end - start) / 2;
        return merge(sort(data, start, mid), sort(data, mid + 1, end));
    }

    private static int[] merge(int[] first, int[] second) {
        int i = 0, j = 0, counter = 0;
        int a[] = new int[first.length + second.length];
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) a[counter++] = first[i++];
            else a[counter++] = second[j++];
        }

        while (i < first.length) a[counter++] = first[i++];
        while (j < second.length) a[counter++] = second[j++];
        return a;
    }
}
