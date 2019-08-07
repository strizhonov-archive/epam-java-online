package onedimension;

/**
 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
 * чисел несколько, то определить наименьшее из них.
 */

public class Ninth {

    public static void findTheSmallestMode(int[] array) {

        int maxIndex = 0;
        int maxCounter = 0;

        for (int i = 0; i < array.length; i++) {

            int counter = 0;

            for (int j = i; j < array.length; j++) {
                if (array[i] == array[j]) {
                    counter++;
                }
            }

            if (counter > maxCounter) {
                maxCounter = counter;
                maxIndex = i;

            } else if (counter == maxCounter) {

                if (array[i] < array[maxIndex]) {
                    maxIndex = i;

                }

            }
        }

        System.out.println("The smallest mode in the array is " + array[maxIndex] + ".");

    }

}
