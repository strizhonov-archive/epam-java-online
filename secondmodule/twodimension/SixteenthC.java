package twodimension;

/**
 * Магическим квадратом порядка n называется квадратная матрица размера n x n, составленная из чисел 1, 2, 3,
 * ..., n 2 так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
 * собой. Построить такой квадрат.
 */

public class SixteenthC {

    /*
        Builds ALL n-sized magic squares with array permutation.
        From n = 4 it takes too much time.
     */
    public static void createAllMagicSquares(int n) {
        int[] square = initializeArray(n);
        permute(square);
    }

    private static int[] initializeArray(int n) {
        int[] arr = new int[n * n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }

    private static void permute(int[] arr) {
        permute(arr, 0, arr.length - 1);
    }

    private static void permute(int[] arr, int i, int n) {

        if (i == n) {
            if (checkArrayForMagic(arr)) {
                printArrAsMatrix(arr);
            }
        } else {
            for (int j = i; j <= n; j++) {
                swap(arr, i, j);
                permute(arr, i + 1, n);
                swap(arr, i, j);
            }
        }

    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static boolean checkArrayForMagic(int[] arr) {

        // Get target sum of elements in rows, columns and diagonals
        int sideLength = (int) Math.sqrt(arr.length);
        int sumOfAllElements = 0;
        for (int i = 1; i <= arr.length; i++) {
            sumOfAllElements += i;
        }
        int targetSum = sumOfAllElements / sideLength;


        // Checking rows
        int sum = 0;
        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            sum += arr[i];
            if (j == sideLength - 1) {
                if (sum != targetSum) {
                    return false;
                } else {
                    sum = 0;
                    j = -1;
                }
            }
        }

        // Checking columns
        sum = 0;
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                sum += arr[i + sideLength * j];
            }
            if (sum != targetSum) {
                return false;
            } else {
                sum = 0;
            }
        }

        // Checking main diagonal
        sum = 0;
        for (int i = 0; i < sideLength; i++) {
            sum += arr[(sideLength + 1) * i];

        }

        if (sum != targetSum) {
            return false;
        }

        // Checking secondary diagonal
        sum = 0;
        for (int i = 0; i < sideLength; i++) {
            sum += arr[(sideLength - 1) * (i + 1)];

        }
        if (sum != targetSum) {
            return false;
        }

        // If all checks passed, true is returned
        return true;

    }

    // Print matrix
    private static void printArrAsMatrix(int[] arr) {

        System.out.println("Magic square found!");

        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            System.out.print(arr[i] + " ");
            if (j == (int) Math.sqrt(arr.length) - 1) {
                j = -1;
                System.out.println();
            }
        }

    }


}
