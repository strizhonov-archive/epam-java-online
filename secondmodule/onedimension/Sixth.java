package onedimension;

public class Sixth {

    public static void summarizeElementsByRule(double[] array) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {

            boolean isISimple = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isISimple = false;
                    break;
                }
            }

            if (isISimple) {
                sum += array[i];
            }
        }

        System.out.println("Sum of elements with prime indexes is " + sum + ".");
    }

}
