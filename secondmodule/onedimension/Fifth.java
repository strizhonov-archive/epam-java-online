package onedimension;

public class Fifth {

    public static void printElementsByRule(int[] array) {

        System.out.println("Integer values, that fits ai > i:");

        for (int i = 0; i < array.length; i++) {
            if (array[i] > i) {
                System.out.print(array[i] + " ");
            }
        }

        System.out.println();
    }
}
