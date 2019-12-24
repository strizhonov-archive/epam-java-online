package twodimension;

/**
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
 * столбец содержит максимальную сумму.
 */

public class Ninth {

    public static void findMaxColumnSum(int[][] matrix) {

        System.out.println("Matrix looks like:");
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


        int[] sumArray = new int[matrix[0].length];
        int maxIndex = 0;

        for (int[] i : matrix) {
            for (int j = 0; j < i.length; j++) {
                sumArray[j] += i[j];
                if (sumArray[j] > sumArray[maxIndex]) {
                    maxIndex = j;
                }
            }
        }


        System.out.println("Sum of column elements:");

        for (int i : sumArray) {
            System.out.print(i + " ");
        }
        System.out.println();


        System.out.println("The biggest sum is in " + (maxIndex + 1) + " column.");
    }

}
