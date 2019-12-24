package twodimension;

/**
 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */

public class Twelfth {

    public static void sortRowsAscending(int[][] matrix) {

        System.out.println("Matrix before rows ascending sorting:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int minIndex = j;
                for (int k = j; k < matrix[i].length; k++) {
                    if (matrix[i][k] < matrix[i][minIndex]) {
                        minIndex = k;
                    }
                }
                int buf = matrix[i][j];
                matrix[i][j] = matrix[i][minIndex];
                matrix[i][minIndex] = buf;
            }
        }


        System.out.println("Matrix after rows ascending sorting:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    public static void sortRowsDescending(int[][] matrix) {

        System.out.println("Matrix before rows descending sorting:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int maxIndex = j;
                for (int k = j; k < matrix[i].length; k++) {
                    if (matrix[i][k] > matrix[i][maxIndex]) {
                        maxIndex = k;
                    }
                }
                int buf = matrix[i][j];
                matrix[i][j] = matrix[i][maxIndex];
                matrix[i][maxIndex] = buf;
            }
        }


        System.out.println("Matrix after rows descending sorting:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}
