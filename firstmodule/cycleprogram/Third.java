package cycleprogram;

/**
 * Найти сумму квадратов первых ста чисел.
 */

public class Third {

    public static void summarizeSquares() {

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += Math.pow(i, 2);
        }

        System.out.println(sum);
    }

}
