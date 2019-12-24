package twodimension;

/**
 * Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */

public class Fifteenth {

    public static void replaceElementsWithMax(int[][] matrix) {

        // Printing matrix before replacing
        System.out.println("Matrix before replacing:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // Search of the max element
        int max = matrix[0][0];

        for (int[] i : matrix) {
            for (int j : i) {
                if (j > max) {
                    max = j;
                }
            }
        }

        // Replacing every element with max
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (counter % 2 == 0) {
                    matrix[i][j] = max;
                }
                counter++;
            }
        }

        // Printing matrix after replacing
        System.out.println("Matrix after replacing:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}
