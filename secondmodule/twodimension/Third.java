package twodimension;

public class Third {

    public static void findRowAndColumn(int k, int p, int[][] matrix) {

        System.out.println("k-row elements are:");

        for (int i = 0; i < matrix[k].length; i++) {
            System.out.print(matrix[k][i] + " ");
        }
        System.out.println();


        System.out.println("p-column elements are:");

        for (int[] i : matrix) {
            System.out.print(i[p] + " ");
        }
        System.out.println();
    }

}
