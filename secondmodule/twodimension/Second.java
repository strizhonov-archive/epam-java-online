package twodimension;

public class Second {

    public static void findDiagonalElements(int[][] matrix) {

        if (matrix.length != matrix[matrix.length - 1].length) {
            System.out.println("Given matrix is not squared.");

        } else {

            System.out.println("Elements on main diagonal are:");

            for (int i = 0; i < matrix.length; i++) {
                System.out.print(matrix[i][i] + " ");
            }

            System.out.println();

        }


    }

}
