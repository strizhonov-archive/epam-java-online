package sorting;

/**
 * Сортировка обменами. Дана последовательность чисел a1 <= a2 <= an. Требуется переставить числа в
 * порядке возрастания. Для этого сравниваются два соседних числа ai и a(i+1) . Если ai > a(i+1) , то делается
 * перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
 * Составить алгоритм сортировки, подсчитывая при этом количества перестановок.
 */

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
