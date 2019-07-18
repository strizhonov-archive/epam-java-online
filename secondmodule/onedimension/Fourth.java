package onedimension;

public class Fourth {

    public static void switchMinAndMax(double[] array) {

        int max = 0;
        int min = 0;

        System.out.println("Array values before switching:");

        for (int i = 0; i < array.length; i++) {

            if (array[i] > array[max]) {
                max = i;
            } else if (array[i] < array[min]) {
                min = i;
            }

            System.out.print(array[i] + " ");
        }

        System.out.println();


        double temp = array[max];
        array[max] = array[min];
        array[min] = temp;


        System.out.println("Array values after switching:");

        for (double j : array) {
            System.out.print(j + " ");
        }

        System.out.println();
    }

}
