package exercises.string;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given a String “aabbbbddcc" find the longest first repeating index and its length. (Input:
 * “aabbbbddcc" Output: [2,4] 2 is the index and 4 is the length).
 */
public class LongestRepeatingChar {
    private static Map<Integer, Map<String, Integer>> map = new TreeMap<>();

    public static void main(String[] args) {
        String data = "aabbbccddddddaaaaaaa";
        int startIndex = 0;
        int length = 0, maxLength = 0, index = 0;
        for (int i = 0; i < data.length(); i++) {
            if (i != 0 && data.charAt(i) != data.charAt(i - 1)) {
                // important key is to identify the break points ex. first see if the index of
                // changing char is printed correctly
                // rest is easy
                if (length > maxLength) {
                    maxLength = length;
                    index = startIndex;
                }
                startIndex = i;
                length = 0;
            }
            length++;

            if (i == data.length() - 1 && length > maxLength) {
                maxLength = length;
                index = startIndex;
            }
        }

        System.out.println(index);
        System.out.println(maxLength);
    }
}
