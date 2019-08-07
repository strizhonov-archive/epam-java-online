package twodimension;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное) (см. pdf файл).
 */

public class Sixth {

    public static void createMatrix(int n) {

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix[i].length - i; j ++) {
                matrix[i][j] = 1;
                matrix[matrix.length - 1 - i][j] = 1;
            }
        }

        System.out.println("Matrix looks like:");

        for(int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}
