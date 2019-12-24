package decomposition;

/**
 * Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
 * являются цифры числа N.
 */

public class Tenth {


    public static void createArrayFromDigits(int number) {

        int digitsCount = getNumberDigitCount(number);
        int[] digits = new int[digitsCount];

        inflateArray(digits, number);

        printResult(digits, number);

    }


    private static int getNumberDigitCount(int number) {
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;

        }
        return count;
    }


    private static void inflateArray(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            int digit = number % 10;
            array[i] = digit;
            number = number / 10;
        }
    }


    private static void printResult(int[] array, int number) {
        System.out.println("Digital array from " + number + " number is:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
