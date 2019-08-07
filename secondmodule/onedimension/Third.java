package onedimension;

/**
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов.
 */

public class Third {

    public static void countElementsByType(double[] array) {

        int negativeCounter = 0;
        int positiveCounter = 0;
        int nullCounter = 0;

        for (double i : array) {
            if (i > 0) {
                positiveCounter++;
            } else {
                if (i == 0) {
                    nullCounter++;
                } else {
                    negativeCounter++;
                }
            }
        }

        System.out.print("There are " + positiveCounter + " positive numbers, ");
        System.out.println(negativeCounter + " negative numbers ");
        System.out.println("and " + nullCounter + " zero numbers in the array.");

    }

}
