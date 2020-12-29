package exercises.string;

public class AllSubsetOfString {
    public static void main(String[] args) {
        String data = "cat";
        findSubstring(data, "", 0);
    }

    private static void findSubstring(String data, String substring, int i) {
        if (i == data.length()) {
            System.out.println(substring + ",");
        } else {
            String s = String.valueOf(data.charAt(i));
            i++;
            findSubstring(data, substring.concat(s), i);
            findSubstring(data, substring, i);
        }
    }
}
