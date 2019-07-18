package twodimension;


public class SixteenthB {
    /*
        Builds ALL n-sized magic squares.
        From n = 4 it takes too much time.
     */
    public static void createAllMagicSquares(int n) {

        // Initialize matrix
        int[][] matrix = initializeMatrix(n);

        // If matrix fits - printing it. Then changing it to the next state.
        boolean isEveryVariantChecked;
        do {
            if (checkMatrixForMagic(matrix, n) && checkMatrixForDuplicates(matrix)) {
                printMatrix(matrix);
            }
            isEveryVariantChecked = increaseByOne(matrix, n);

        } while (!isEveryVariantChecked);

    }


    // Initialize matrix with the start (lowest) values
    private static int[][] initializeMatrix(int n) {

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = j + 1 + (i * matrix.length);
            }
        }

        return  matrix;
    }


    private static boolean checkMatrixForMagic(int[][] matrix, int n) {

        // Get target sum of elements in rows, columns and diagonals
        int sumOfAllElements = 0;
        for (int i = 1; i <= n * n; i++) { sumOfAllElements += i; }
        int targetSum = sumOfAllElements / n;


        int sum;

        // Checking rows
        for (int[] i : matrix) {
            sum = 0;
            for (int j : i) {
                sum += j;
            }
            if (sum != targetSum) {
                return false;
            }
        }

        // Checking columns
        for (int i = 0; i < matrix[0].length; i++) {
            sum = 0;
            for (int[] j : matrix) {
                sum += j[i];
            }
            if (sum != targetSum) {
                return false;
            }
        }

        // Checking diagonals
        sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        if (sum != targetSum) {
            return false;
        }

        sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];

        }
        if (sum != targetSum) {
            return false;
        }

        // If all checks passed, true is returned
        return true;

    }


    // Check if there are duplicate elements in the matrix
    private static boolean checkMatrixForDuplicates(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                int comparedValue = matrix[i][j];
                int counter = 0;

                for (int m = i; m < matrix.length; m++) {
                    for (int n = 0; n < matrix[i].length; n++) {
                        if (comparedValue == matrix[m][n]) {
                            counter++;
                            if (counter > 1) { return false; }
                        }

                    }
                }

            }
        }

        return true;
    }


    // Print matrix
    private static void printMatrix(int[][] matrix) {

        System.out.println("Magic square found!");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }


    // Increases last value of matrix by one. If this value becomes more than n * n,
    // it is changed to 1, and then (last - 1) matrix value is increased by one and checked by the same rule, and so on.
    // When there are no more options to increase, returning true. That means that all possible squares checked.
    private static boolean increaseByOne(int[][] matrix, int n) {

        for (int i = matrix.length - 1; i >= 0; i--) {

            for (int j = matrix[i].length - 1; j >= 0; j--) {

                if (matrix[i][j] + 1 <= n * n) {
                    matrix[i][j] = matrix[i][j] + 1;
                    return false;
                } else {
                    matrix[i][j] = 1;
                }

            }
        }

        return true;
    }

}
