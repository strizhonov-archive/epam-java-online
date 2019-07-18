package decomposition;

public class Seventh {

    public static void findFactorialSumOfOdds() {

        int sum = 0;
        for (int i = 1; i <= 9; i += 2) {
            sum += getFactorial(i);
        }

        printResult(sum);

    }

    private static int getFactorial(int upperBound) {
        int factorial = 1;
        for (int i = 2; i <= upperBound; i++) {
            factorial *= i;
        }
        return  factorial;
    }

    private static void printResult(int sum) {
        System.out.println("Factorials sum of odds between 1 and 9 is " + sum + ".");
    }
}
