package exercises.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinDistanceBetweenWords {
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String data = "geeks for geeks contribute practice and practice and practice";
        String w1 = "geeks";
        String w2 = "practice";

        String[] dataArray = data.split(" ");
        Integer w1Index = null, w2Index = null;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < dataArray.length; i++) {
            String curr = dataArray[i];
            if (curr.equals(w1) || curr.equals(w2)) {
                System.out.println(curr);
                // if map do not contains curr then update map
                if (!map.containsKey(curr)) map.put(curr, i);

                // if map do not contains others entry update current
                if (map.containsKey((curr.equals(w1) ? w2 : w1))) map.put(curr, i);

                // if map contains both calculate diff and new diff
                if (map.containsKey(w1) && map.containsKey(w2)) {
                    String other = (curr.equals(w1)) ? w2 : w1;
                    int i1 = map.get(curr);
                    int i2 = map.get(other);
                    System.out.println("i1 : " + i1 + " i2: " + i2);

                    if (Math.abs(i - i2) < i1 - i2) {
                        map.put(curr, i);
                    }
                }
            }
        }

        System.out.println(map);
    }
}
