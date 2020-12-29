package exercises;

public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.println(fibIter(7));
    }

    private static int fibRec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }

    private static int fibIter(int n) {
        int first = 0, second = 1, sum = 0;
        int count = 2;

        while (count <= n) {
            sum = first + second;
            first = second;
            second = sum;
            count++;
        }
        return sum;
    }
}
