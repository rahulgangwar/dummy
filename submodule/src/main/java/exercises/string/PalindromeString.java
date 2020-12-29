package exercises.string;

import java.util.Scanner;

public class PalindromeString {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Enter name to check for palindrome.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Checking palindrome for : " + name);
        boolean result = isPalindrome(name);
        System.out.println("Result: " + result);
    }

    public static boolean isPalindrome(String name) {
        boolean isPalindrome = true;
        int nameLength = name.length();

        int endPointer = nameLength - 1;
        for (int i = 0; i < nameLength; i++) {
            System.out.println("Char : " + name.charAt(i));
            if (i >= endPointer) {
                System.out.println("Terminating !! i=" + i + " endPointer=" + endPointer);
                break;
            }
            if (name.charAt(i) != name.charAt(endPointer)) {
                System.out.println("Mismatch found !!");
                isPalindrome = false;
                break;
            }
            endPointer--;
        }
        return isPalindrome;
    }
}
