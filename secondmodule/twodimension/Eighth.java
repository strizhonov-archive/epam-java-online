package twodimension;

import java.util.Scanner;

/**
 * В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
 * на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
 * пользователь с клавиатуры.
 */

public class Eighth {

    public static void switchColumns(int[][] matrix) {

        // Printing matrix before switching
        System.out.println("Matrix before switching:");
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // Getting columns from user to switch
        Scanner sc = new Scanner(System.in);

        int firstNumber = -1;
        while (!(firstNumber >= 1 && firstNumber <= matrix[0].length)) {
            System.out.println("Enter first column number from 1 up to " + matrix[0].length + ":");
            if (!sc.hasNextInt()) {
                sc.next();
            } else {
                firstNumber = sc.nextInt();
            }
        }
        firstNumber--;


        int secondNumber = -1;
        while (!(secondNumber >= 1 && secondNumber <= matrix[0].length)) {
            System.out.println("Enter second column number from 1 up to " + matrix[0].length + ":");
            if (!sc.hasNextInt()) {
                sc.next();
            } else {
                secondNumber = sc.nextInt();
            }
        }
        secondNumber--;
        sc.close();


        // Switching columns
        int[] tempArray = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            tempArray[i] = matrix[i][firstNumber];
            matrix[i][firstNumber] = matrix[i][secondNumber];
            matrix[i][secondNumber] = tempArray[i];
        }


        // Printing matrix after switching
        System.out.println("Matrix after switching:");

        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
