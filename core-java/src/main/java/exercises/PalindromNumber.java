package exercises;

import java.util.Scanner;

public class PalindromNumber {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        System.out.println("Enter number to check for palindrome.");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Checking palindrome for : " + number);
        boolean result = isPalindrome(number);
        System.out.println("Result: " + result);
    }

    // my solution // not optimised
    public static boolean isPalindrome(int number) {
        boolean isPalindrome = true;

        // we can just convert the number to string and use the method used for
        // string
        System.out.println("Converted to string : " + Integer.toString(number));

        int iterationNumber = 0;
        while (number > 10) {
            System.out.println(
                    "Iteration number ------- " + iterationNumber + " Number : " + number);
            int temp = number;
            int last = number % 10; // getting last number

            int tenMultiplier = 1;
            while (temp > 10) {
                temp = temp / 10;
                tenMultiplier = tenMultiplier * 10;
            }

            tenMultiplier = tenMultiplier / 10;
            System.out.println("tenMultiplier : " + tenMultiplier);
            int first = temp;

            System.out.println("Checking for First [" + first + "] and Last [" + last + "]");
            if (first != last) {
                System.out.println("Failed !!!");
                isPalindrome = false;
                break;
            }

            // re adusting the number
            number = (number - last) / 10; // removing last number
            number = (number - (first * tenMultiplier)); // removing first
            // number
            System.out.println("------Done------ : New number : " + number);
        }
        return isPalindrome;
    }

    public static boolean isPalindromeOptimised(int n) {
        int r, sum = 0, temp;
        temp = n;
        // start total from 0
        // multiply total with 10 and add the remainder then repeat while number
        // greater then 0
        // total should be equal to number
        while (n > 0) {
            r = n % 10; // getting remainder
            sum = (sum * 10) + r;
            n = n / 10;
        }
        if (temp == sum) return true;
        else return false;
    }
}
