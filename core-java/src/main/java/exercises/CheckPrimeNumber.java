package exercises;

import java.util.Scanner;

public class CheckPrimeNumber {

    public static void main(String[] args) {
        System.out.println("Enter the number to check: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        boolean result = isPrime(number);
        System.out.println("Is prime: " + result);
    }

    public static boolean isPrime(int number) {
        System.out.println("Checking if " + number + " is prime");
        boolean isPrime = true;
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                System.out.println("failing prime check at i = " + i);
                isPrime = false;
            }
        }
        return isPrime;
    }
}
