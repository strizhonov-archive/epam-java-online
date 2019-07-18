package sorting;

public class Sixth {

    public static void sortWithShell(int[] array) {

        printBefore(array);

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int buf = array[i];
                array[i] = array[i + 1];
                array[i + 1] = buf;
                if (i >= 1) { i -= 2; }
            }
        }

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

}
