package onedimension;

public class Tenth {

    public static void compressArray(int[] array) {

        System.out.println("Array before compressing:");

        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println();


        for (int i = 1; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            } else {
                array[i - i / 2] = array[i];
                array[i] = 0;
            }
        }


        System.out.println("Array after compressing:");

        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println();

    }
}
