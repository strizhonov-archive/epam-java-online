package onedimension;

public class Ninth {

    public static void findTheSmallestMode(int[] array) {

        int maxIndex = 0;
        int maxCounter = 0;

        for (int i = 0; i < array.length; i++) {

            int counter = 0;

            for (int j = i; j < array.length; j++) {
                if (array[i] == array[j]) {
                    counter++;
                }
            }

            if (counter > maxCounter) {
                maxCounter = counter;
                maxIndex = i;

            } else if (counter == maxCounter) {

                if (array[i] < array[maxIndex]) {
                    maxIndex = i;

                }

            }
        }

        System.out.println("The smallest mode in the array is " + array[maxIndex] + ".");

    }

}
