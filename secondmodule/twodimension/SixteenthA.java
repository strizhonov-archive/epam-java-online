package twodimension;

public class SixteenthA {

    /*
        Builds ONE n-seized magic square. Requires odd n.
     */

    public static void createMagicSquare(int n) {

        int[][] matrix = new int[n][n];

        if (n % 2 == 0) {
            printWarning("Passed size of square is even, should be odd.");
        } else {
            inflate(matrix);
            print(matrix);
        }


    }

    private static void inflate(int[][] matrix) {

        int size = matrix.length;

        // Setting position for 1
        int i = size / 2;
        int j = size - 1;

        // Putting values in magic square
        for (int num = 1; num <= size * size; ) {
            if (i == -1 && j == size) {
                j = size - 2;
                i = 0;
            } else {
                if (j == size) {
                    j = 0;
                }
                if (i < 0) {
                    i = size - 1;
                }
            }

            if (matrix[i][j] != 0) {
                j -= 2;
                i++;
                continue;
            } else {
                matrix[i][j] = num++;
            }
            j++;
            i--;
        }
    }

    private static void print(int[][] matrix) {

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

    private static void printWarning(String warningMessage) {
        System.out.println(warningMessage);
    }

}
