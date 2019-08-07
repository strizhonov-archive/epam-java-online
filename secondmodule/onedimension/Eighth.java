package onedimension;

/**
 * Дана последовательность целых чисел a1, a2, ..., an. Образовать новую последовательность, выбросив из
 * исходной те члены, которые равны min(a1, a2 , ..., an).
 */

public class Eighth {

    public static void refineArray(int[] array) {

        System.out.println("Array elements before refining:");

        int min = array[0];
        for (int i : array) {
            if (i < min) { min = i; }
            System.out.print(i + " ");
        }

        System.out.println();


        int minCounter = 0;
        for (int i : array) {
            if (i == min) {
                minCounter++;
            }
        }


        int[] resultArray = new int[array.length - minCounter];

        System.out.println("Array elements after refining:");

        int index = 0;
        for (int i : array) {

            if (i != min) {
                resultArray[index] = i;
                System.out.print(resultArray[index] + " ");
                index++;
            }

        }

        System.out.println();

    }

}
