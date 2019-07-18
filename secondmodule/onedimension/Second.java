package onedimension;

public class Second {

    public static void replaceElements(double[] array, int z) {

        int counter = 0;

        System.out.println("New array values:");

        for (int i = 0; i < array.length; i++) {

            if (array[i] > z) {
                array[i] = z;
                counter++;
            }

            System.out.print(array[i] + " ");
        }

        System.out.println();

        System.out.println("Amount of replacements is " + counter + ".");

    }

}
