package decomposition;

/**
 * Задан массив D. Определить следующие суммы: D[1] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 * Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
 * массива с номерами от k до m.
 */

public class Eighth {


    public static void findSumByTriple(int[] array, int lowerBound, int upperBound) {

        if (checkBounds(array, lowerBound, upperBound)) {

            int triplesCount = Math.abs((upperBound - lowerBound) / 3);

            if (triplesCount != 0) {
                int sum = 0;
                for (int i = 1; i <= triplesCount; i++) {
                    sum += sumTriple(array, lowerBound);

                    printSum(sum, lowerBound);

                    lowerBound += 3;
                    sum = 0;
                }
            } else {
                printWarning("There is no triples in the array.");
            }

        } else {
            printWarning("Illegal bounds of array.");
        }
    }

    private static boolean checkBounds(int[] array, int lowerBound, int upperBound) {
        return !(lowerBound < 0
                || upperBound < 0
                || lowerBound > array.length - 1
                || upperBound > array.length - 1);
    }

    private static int sumTriple(int[] array, int startIndex) {
        int sum = 0;
        for (int i = startIndex; i <= startIndex + 2; i++) {
            sum += array[i];
        }
        return sum;
    }

    private static void printSum(int sum, int lowerBound) {
        System.out.println("Sum of elements between " + lowerBound + " and " + (lowerBound + 2) + " is " + sum + ".");

    }

    private static void printWarning(String warning) {
        System.out.println(warning);

    }





}
