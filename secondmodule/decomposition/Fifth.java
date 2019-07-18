package decomposition;

public class Fifth {

    public static void findSecondMax(int[] array) {

        int max = getMax(array);
        int secondMax = array[0];
        for (int i : array) {
            if (i < max && i > secondMax) {
                secondMax = i;
            }
        }

        if (max == secondMax) {
            printNegativeResult();
        } else {
            printPositiveResult(secondMax);
        }

    }

    private static int getMax(int[] array) {

        int max = array[0];

        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return  max;
    }

    private static void printNegativeResult() {
        System.out.println("Either array has only one element or all elements are equal.");
    }

    private static void printPositiveResult(int number) {
        System.out.println("The greatest element before maximum is " + number + ".");
    }

}
