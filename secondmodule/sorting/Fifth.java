package sorting;

public class Fifth {

    public static void sortWithInserting(int[] array) {

        printBefore(array);

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int valueToInsert = array[i + 1];
                int insertIndex = doubleSearch(array, i, valueToInsert);
                for (int j = i + 1; j > insertIndex; j--) {
                    array[j] = array[j - 1];
                }
                array[insertIndex] = valueToInsert;
            }
        }

        printAfter(array);

    }

    private static int doubleSearch(int[] array, int sortedIndex, int valueToInsert) {

        if (valueToInsert > array[sortedIndex + 1]) {
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


    private static void printBefore(int[] array) {
        System.out.println("Array before sorting:");

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    private static void printAfter(int[] array) {
        System.out.println("Array after sorting:");

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
