package twodimension;

import java.util.Random;
import java.util.Scanner;

/**
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
 * единиц равно номеру столбца.
 */

public class Fourteenth {

    public static void createMatrix() {

        // Getting matrix size from user
        Scanner sc = new Scanner(System.in);

        int rows = 0;
        int columns = 0;

        while (columns > rows || rows <= 0 || columns <= 0) {

            while (rows <= 0) {
                System.out.println("Enter amount of rows:");

                while (!sc.hasNextInt()) {
                    System.out.println("Enter amount of rows:");
                    sc.next();
                }

                rows = sc.nextInt();

                if (rows <= 0) {
                    System.out.println("The number of rows should be positive.");
                }
            }


            while (columns <= 0) {
                System.out.println("Enter amount of columns:");

                while (!sc.hasNextInt()) {
                    System.out.println("Enter amount of columns:");
                    sc.next();
                }

                columns = sc.nextInt();

                if (columns <= 0) {
                    System.out.println("The number of columns should be positive.");
                }
            }
            if (columns > rows) {
                System.out.println("Illegal parameters of the matrix. Number of rows should be equal or greater than number of columns.");
            }
        }


        // Creating and inflating matrix
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < i + 1; j++) {

                Random random = new Random();

                int index = random.nextInt(matrix.length);

                if (matrix[index][i] == 1) {
                    j--;
                } else {
                    matrix[index][i] = 1;
                }

            }
        }

        // Printing matrix
        System.out.println("Matrix looks like:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}
