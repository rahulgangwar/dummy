package exercises;

public class DuplicateInArray {
    public static void main(String[] args) {
        int[] numbers = new int[] {1, 2, 3, 1, 4, 5, 2};
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    System.out.println("Duplicate : " + numbers[i]);
                }
            }
        }
    }
}
