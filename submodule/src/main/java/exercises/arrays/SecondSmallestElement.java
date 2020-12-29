package exercises.arrays;

public class SecondSmallestElement {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 0};

        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE, current = 0;

        for (int datum : data) {
            current = datum;
            if (current < smallest) {
                secondSmallest = smallest;
                smallest = current;
            } else if (current < secondSmallest && current != smallest) {
                secondSmallest = current;
            }
        }

        System.out.println("smallest:" + smallest);
        System.out.println("secondSmallest:" + secondSmallest);
    }
}
