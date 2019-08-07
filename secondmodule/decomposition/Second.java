package decomposition;

/**
 * Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */

public class Second {

    public static void findGreatestCommonDivisor(int a, int b, int c, int d) {

        int gcd = 1;

        // Main logic
        int min = getMin(a, b, c, d);

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0 && c % i == 0 && d % i == 0) {
                gcd = i;
            }
        }

        printResult(a, b, c, gcd);

    }

    private static int getMin(int a, int b, int c, int d) {

        int min1;
        if (a < b) {
            min1 = a;
        } else {
            min1 = b;
        }

        int min2;
        if (c < d) {
            min2 = c;
        } else {
            min2 = d;
        }

        if (min1 < min2) {
            return min1;
        } else {
            return min2;
        }

    }

    private static void printResult(int firstNum, int secondNum, int thirdNum, int gcd) {
        System.out.println("The greatest common divisor for "
                + firstNum + ", " + secondNum + " and "
                + thirdNum + " is " + gcd + ".");
    }


}
