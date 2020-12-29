package exercises.string;

public class LargestSubstringWithUniqueChars {
    public static void main(String[] args) {
        String data = "aaabcbdeaf";
        String largestSubsting = "";
        String tempString = "";

        for (char c : data.toCharArray()) {
            String s = String.valueOf(c);
            if (tempString.contains(s)) {
                if (tempString.length() > largestSubsting.length()) {
                    largestSubsting = tempString;
                }
                // initialise from last occurence of the char in tempString
                tempString = tempString.substring(tempString.indexOf(s));
            } else {
                tempString = tempString.concat(s);
            }
        }

        if (tempString.length() > largestSubsting.length()) {
            largestSubsting = tempString;
        }

        System.out.println(largestSubsting);
    }
}
