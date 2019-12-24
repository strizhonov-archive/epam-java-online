package decomposition;

/**
 * Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
 */

public class Sixth {

    public static void checkIfIntegersAreCoprime(int a, int b, int c) {

        boolean areIntegersCoprime = true;

        if (checkIfThereIsZero(a, b, c)) {
            areIntegersCoprime = false;
        } else {

            int absMin = getAbsMin(a, b, c);

            for (int i = 2; i <= absMin; i++) {
                if (a % i == 0 && b % i == 0 && c % i == 0) {
                    areIntegersCoprime = false;
                    break;
                }
            }
        }

        printResult(areIntegersCoprime, a, b, c);

    }


    private static boolean checkIfThereIsZero(int a, int b, int c) {
        return a == 0 || b == 0 || c == 0;
    }


    private static int getAbsMin(int a, int b, int c) {
        a = Math.abs(a);
        b = Math.abs(b);
        c = Math.abs(c);

        if (a <= b && a <= c) {
            return a;
        }
        if (b <= a && b <= c) {
            return b;
        }

        return c;

    }


    private static void printResult(boolean areIntegersCoprime, int a, int b, int c) {
        if (areIntegersCoprime) {
            System.out.println("Integers " + a + ", " + b + " and " + c + " are coprime.");
        } else {
            System.out.println("Integers " + a + ", " + b + " and " + c + " are not coprime.");
        }
    }

}
