package sorting;

/**
 * Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <= an и b1 <= b2 <= bm .
 * Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <= bm в первую
 * последовательность так, чтобы новая последовательность оставалась возрастающей.
 */

public class Seventh {

    public static void mergeAscendingArrays(int[] firstArray, int[] secondArray) {

        printBefore(firstArray, secondArray);

        for (int i = 0; i < secondArray.length; i++) {
            int valueToInsert = secondArray[i];
            int insertIndex = doubleSearch(firstArray, firstArray.length - 1, valueToInsert);
            if (insertIndex <= firstArray.length - 1) {
                printCommonResult(i, insertIndex);
            } else {
                printLastIndexResult(i);
            }
        }
    }

    private static int doubleSearch(int[] array, int sortedIndex, int valueToInsert) {

        if (valueToInsert > array[sortedIndex]) {
            return sortedIndex + 1;
        }

        int startBound = 0;
        int endBound = sortedIndex;

        while (endBound - startBound != 0) {
            int middleIndex = (startBound + endBound) / 2;

            if (array[middleIndex] > valueToInsert) {
                endBound = middleIndex;
            }
            if (array[middleIndex] < valueToInsert) {
                startBound = middleIndex + 1;
            }
            if (array[middleIndex] == valueToInsert) {
                endBound = middleIndex;
                startBound = middleIndex;
            }
        }

        return startBound;
    }

    private static void printBefore(int[] firstArray, int[] secondArray) {
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

    }

    private static void printCommonResult(int index, int insertIndex) {
        System.out.println("Put b" + (index + 1) + " before a" + (insertIndex + 1));
    }

    private static void printLastIndexResult(int index) {
        System.out.println("Put b" + (index + 1) + " at the end");
    }

}
