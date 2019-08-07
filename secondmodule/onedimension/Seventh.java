package onedimension;

/**
 * Даны действительные числа a1, a2, ..., an. Найти
 * max(a1 + a2n, a2 + a2n − 1 , ..., an + an + 1) .
 */

public class Seventh {

    public static void findMax(double[] array) {

        if (array.length % 2 != 0) {

            System.out.println("Illegal array. Array's length should be even.");

        } else {

            double max = array[0] + array[array.length - 1];

            for (int i = 0; i < array.length / 2; i++) {
                double sum = array[i] + array[array.length - 1 - i];
                if (sum > max) {
                    max = sum;
                }
            }

            System.out.println("Maximum sum is " + max + ".");

        }


    }
}
