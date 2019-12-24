package sorting;

/**
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
 * один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
 * дополнительный массив.
 */

public class First {

    public static void mergeArrays(int[] firstArray, int[] secondArray, int k) {

        int[] resultArray = new int[firstArray.length + secondArray.length];

        int gap = 0;
        for (int i = 0; i < resultArray.length; i++) {

            if (i == k) {

                for (int j = i; j < i + secondArray.length; j++) {
                    resultArray[j] = secondArray[j - i];
                }

                gap = secondArray.length;
                i += gap - 1;

            } else {
                resultArray[i] = firstArray[i - gap];
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
