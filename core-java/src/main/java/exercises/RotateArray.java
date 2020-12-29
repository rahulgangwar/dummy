package exercises;

public class RotateArray {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        leftRotateArray(data, 4);
    }

    private static void leftRotateArray(int[] data, int rotateBy) {
        int length = data.length;

        /* To get the starting point of
        rotated array */
        int mod = rotateBy % length;
        int[] newArray = new int[length];

        // Prints the rotated array from
        // start position
        for (int i = 0; i < length; ++i) {
            newArray[i] = data[(i + mod) % length];
        }

        // printing rotated array
        for (int i : newArray) {
            System.out.print(i + ",");
        }
    }
}
