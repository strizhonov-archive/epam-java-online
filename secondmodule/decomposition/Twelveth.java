package decomposition;

public class Twelveth {

    public static void createArrayByRule(int k, int n) {

        int[] array = new int[getArrayLength(k, n)];

        inflateArray(array, k, n);

        printResult(array);

    }

    private static void inflateArray(int[] array, int k, int n) {
        int counter = 0;
        for (int i = 1; i <= n; i ++) {
            if (getDigitSum(i) == k) {
                array[counter] = i;
                counter++;
            }

        }
    }

    private static int getArrayLength(int k, int n) {

        int counter = 0;
        for (int i = 1; i <= n; i ++) {
            if (getDigitSum(i) == k) {
                counter++;
            }

        }

        return counter;
    }

    private static int getDigitSum(int number) {

        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += digit;
            number = number / 10;
        }
        return sum;
    }

    private static void printResult(int[] array) {

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
