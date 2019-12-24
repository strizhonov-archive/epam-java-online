package sorting;

/**
 * Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента ai и a(i+1). Если ai <= a(i+1), то продвигаются
 * на один элемент вперед. Если ai > a(i+1), то производится перестановка и сдвигаются на один элемент назад.
 * Составить алгоритм этой сортировки.
 */

public class Sixth {

    public static void sortWithShell(int[] array) {

        printBefore(array);

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int buf = array[i];
                array[i] = array[i + 1];
                array[i + 1] = buf;
                if (i >= 1) {
                    i -= 2;
                }
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
