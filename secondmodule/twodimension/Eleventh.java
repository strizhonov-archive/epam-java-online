package twodimension;

import java.util.Random;

public class Eleventh {

    public static void countFives() {

        int[][] matrix = new int[10][20];

        System.out.println("Random matrix looks like:");

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                Random random = new Random();
                matrix[i][j] = random.nextInt(16);
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }


        System.out.println("There are 3 and more fives in the next rows:");

        for (int i = 0; i < matrix.length; i++) {
            int counter = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 5) {
                    counter++;
                }
                if (counter == 3) { break; }
            }
            if (counter >= 3) {
                System.out.print(i + 1 + " ");
            }
        }

    }
}
