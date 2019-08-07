package sorting;

/**
 * Даны дроби p1/q1, p2/q2 , ..., pn/qn (pi, qi - натуральные). Составить программу, которая приводит эти дроби к
 * общему знаменателю и упорядочивает их в порядке возрастания.
 */

public class Eighth {

    public static void convertAndSort(long[] numerators, long[] denominators) {

        printBefore(numerators, denominators);

        if (numerators.length == denominators.length) {

            // Find common Denominator
            int commonDenominator = 1;
            for (long l : denominators) {
                commonDenominator *= l;
            }

            // Converting fraction according to denominator
            for (int i = 0; i < denominators.length; i++) {

                long k = commonDenominator / denominators[i];
                denominators[i] = commonDenominator;
                numerators[i] = numerators[i] * k;

            }

            // Sorting numerators with Shell's method
            for (int i = 0; i < numerators.length - 1; i++) {
                if (numerators[i] > numerators[i + 1]) {
                    long buf = numerators[i];
                    numerators[i] = numerators[i + 1];
                    numerators[i + 1] = buf;
                    if (i >= 1) { i -= 2; }
                }
            }

            printAfter(numerators, denominators);

        } else {
            printWarning("Illegal data. Arrays' length should by equal.");
        }

    }

    private static void printBefore(long[] numerators, long[] denominators) {
        System.out.println("Fractions before sorting:");

        for (int i = 0; i < numerators.length; i++) {
            System.out.print(numerators[i] + "/" + denominators[i] + " ");
        }
        System.out.println();
    }

    private static void printAfter(long[] numerators, long[] denominators) {
        System.out.println("Fractions after sorting:");

        for (int i = 0; i < numerators.length; i++) {
            System.out.print(numerators[i] + "/" + denominators[i] + " ");
        }
        System.out.println();
    }

    private static void printWarning(String warningMessage) {
        System.out.println(warningMessage);
    }

}
