package twodimension;

import java.text.DecimalFormat;

/**
 * Сформировать квадратную матрицу порядка N по правилу:
 * A[I,J] = sin((I^2 - J^2) / N)
 * и подсчитать количество положительных элементов в ней.
 */

public class Seventh {

    public static void createMatrixFromFunction(int n) {

        double[][] matrix = new double[n][n];

        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                matrix[i][j] = Math.sin((Math.pow(i, 2) + Math.pow(j, 2)) / n);
                if (matrix[i][j] > 0) { counter++; }

            }
        }


        System.out.println("There is (are) " + counter + " positive elements in the matrix. The matrix looks like:");

        DecimalFormat df = new DecimalFormat("#.##");

        for(double[] i : matrix) {
            for (double j : i) {
                System.out.print(df.format(j) + "  ");
            }
            System.out.println();
        }
    }

}
