package sorting;

/**
 * Даны две последовательности a1 <= a2 <= an и b1 <= b2 <= bm . Образовать из них новую последовательность
 * чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.
 */

public class Second {

    public static void mergeAscendingArrays(int[] firstArray, int[] secondArray) {

        int[] resultArray = new int[firstArray.length + secondArray.length];

        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < resultArray.length; i++) {
            if (firstIndex != firstArray.length) {

                if (secondIndex == secondArray.length || firstArray[firstIndex] < secondArray[secondIndex]) {
                    resultArray[i] = firstArray[firstIndex];
                    firstIndex++;
                } else {
                    resultArray[i] = secondArray[secondIndex];
                    secondIndex++;
                }

            } else {

                if (secondIndex != secondArray.length) {
                    resultArray[i] = secondArray[secondIndex];
                    secondIndex++;
                }

            }

        }

        printResult(firstArray, secondArray, resultArray);

    }

    private static void printResult(int[] firstArray, int[] secondArray, int[] thirdArray) {

        System.out.println("First array:");

        for (int i : firstArray) {
            System.out.print(i + " ");
        }
        System.out.println();


        System.out.println("Second array:");

        for (int i : secondArray) {
            System.out.print(i + " ");
        }
        System.out.println();


        System.out.println("Result array:");

        for (int i : thirdArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
