package twodimension;

public class Tenth {

    public static void findPositiveElementsOnDiagonal(int[][] matrix) {

        if (matrix.length != matrix[matrix.length - 1].length) {
            System.out.println("Given matrix is not squared.");

        } else {

            System.out.println("Positive element(s) on the main diagonal is (are):");

            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][i] > 0) {
                    System.out.print(matrix[i][i] + " ");
                }
            }

            System.out.println();

        }

    }

}
