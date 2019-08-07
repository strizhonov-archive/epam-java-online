package twodimension;

/**
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное) (см. pdf файл).
 */

public class Fifth {

    public static void createMatrix(int n) {

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length - i; j++) {
                matrix[j][i] = j + 1;
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
