package branch;

/**
 * Найти max{min(a, b), min(c, d)}.
 */

public class Second {

    public static void findMaxFromMin(double a, double b, double c, double d) {

        double minFromFirstPair;
        if (a < b) {
            minFromFirstPair = a;
        } else {
            minFromFirstPair = b;
        }

        double minFromSecondPair;
        if (c < d) {
            minFromSecondPair = c;
        } else {
            minFromSecondPair = d;
        }

        double max;
        if (minFromFirstPair > minFromSecondPair) {
            max = minFromFirstPair;
        } else {
            max = minFromSecondPair;
        }

        System.out.println(max);
    }

}
