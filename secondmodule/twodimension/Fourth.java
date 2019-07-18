package twodimension;

public class Fourth {

    public static void createMatrix(int n) {

        int[][] matrix = new int[n][n];

        for(int i = 0; i < matrix.length; i += 2) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = j + 1;
                matrix[i + 1][j] = n - j;
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
