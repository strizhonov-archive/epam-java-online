package twodimension;

/**
 * Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.
 */

public class Thirteen {

    public static void sortColumnsAscending(int[][] matrix) {

        System.out.println("Matrix before column ascending sorting:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int minIndex = j;
                for (int k = j; k < matrix.length; k++) {
                    if (matrix[k][i] < matrix[minIndex][i]) {
                        minIndex = k;
                    }
                }
                int buf = matrix[j][i];
                matrix[j][i] = matrix[minIndex][i];
                matrix[minIndex][i] = buf;
            }
        }


        System.out.println("Matrix after column ascending sorting:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }


    public static void sortColumnsDescending(int[][] matrix) {

        System.out.println("Matrix before column descending sorting:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int maxIndex = j;
                for (int k = j; k < matrix.length; k++) {
                    if (matrix[k][i] > matrix[maxIndex][i]) {
                        maxIndex = k;
                    }
                }
                int buf = matrix[j][i];
                matrix[j][i] = matrix[maxIndex][i];
                matrix[maxIndex][i] = buf;
            }
        }


        System.out.println("Matrix after column descending sorting:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
