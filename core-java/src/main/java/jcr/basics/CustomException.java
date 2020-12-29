package jcr.basics;

public class CustomException extends Exception {
    CustomException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        System.out.println(new CustomException("this is my exception"));
    }
}
