package exercises.arrays;

import java.util.*;

public class GroupAnagrams {
    private static Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        String[] data = {"cat", "dog", "tac", "god", "act"};

        for (String current : data) {
            char[] sortData = current.toCharArray();
            Arrays.sort(sortData);
            String sorted = new String(sortData);
            if (map.containsKey(sorted)) {
                List<String> anagrams = map.get(sorted);
                anagrams.add(current);
                map.put(sorted, anagrams);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(current);
                map.put(sorted, anagrams);
            }
        }

        System.out.println(map.values());
    }
}
