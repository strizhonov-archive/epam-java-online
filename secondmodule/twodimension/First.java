package twodimension;

public class First {

    public static void findColumnsByRule(int[][] matrix) {

        int counter = 0;

        for (int i = 1; i < matrix[0].length; i += 2) {

            if (matrix[0][i] > matrix[matrix.length - 1][i]) {
                counter++;
                System.out.println(counter + " column:");

                for (int[] j : matrix) {
                    System.out.println(j[i]);

                }
            }
        }
    }

}
