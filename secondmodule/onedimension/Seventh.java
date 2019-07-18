package onedimension;

public class Seventh {

    public static void findMax(double[] array) {

        if (array.length % 2 != 0) {

            System.out.println("Illegal array. Array's length should be even.");

        } else {

            double max = array[0] + array[array.length - 1];

            for (int i = 0; i < array.length / 2; i++) {
                double sum = array[i] + array[array.length - 1 - i];
                if (sum > max) {
                    max = sum;
                }
            }

            System.out.println("Maximum sum is " + max + ".");

        }


    }
}
