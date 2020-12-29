package exercises.string;

import java.util.Scanner;

public class StringReverse {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Enter string to reverse : ");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.next();
        StringBuilder newString = new StringBuilder();
        for (int i = data.length() - 1; i >= 0; i--) {
            newString.append(data.charAt(i));
        }
        System.out.println("Reversed string : " + newString.toString());

        // string builder also comes with its own reverse method
        System.out.println(
                "Reversed string : " + new StringBuilder().append(data).reverse().toString());
    }
}
