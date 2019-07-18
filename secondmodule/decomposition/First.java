package decomposition;

public class First {

    public static void findLeastCommonMultiple(int a, int b) {
        int lcm = a * b / getGreatestCommonDivisor(a, b);
        printResult(a, b, lcm);
    }

    private static int getGreatestCommonDivisor(int a, int b) {

        int gcd = 1;

        // Main logic
        int min = getMin(a, b);

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    private static int getMin(int a, int b) {

        if (a > b) {
            return b;
        } else {
            return a;
        }

    }

    private static void printResult(int firstNum, int secNum, int lcm) {
        System.out.println("The least common multiple for " + firstNum + " and " + secNum + " is " + lcm + ".");
    }

}
