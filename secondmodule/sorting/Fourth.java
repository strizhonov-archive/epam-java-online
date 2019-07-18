package sorting;

public class Fourth {

    public static void sortWithSwitching(int[] array) {

        printBefore(array);

        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    count++;
                }
            }
        }

        printSwitches(count);
        printAfter(array);

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

    private static void printSwitches(int switchCount) {
        System.out.println("Switches: " + switchCount);
    }

}
