package decomposition;

/**
 * Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */

public class Eleventh {

    public static void compareNumbersByDigitAmount(int a, int b) {

        int firstNumberDigitCount = getDigitCount(a);
        int secondNumberDigitCount = getDigitCount(b);

        if (firstNumberDigitCount > secondNumberDigitCount) {
            printFirstGreaterResult(a, b);
        } else if (secondNumberDigitCount > firstNumberDigitCount) {
            printSecondGreaterResult(a, b);
        } else {
            printEqualResult(a, b);
        }
    }


    private static int getDigitCount(int number) {
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;

        }
        return count;
    }


    private static void printFirstGreaterResult(int a, int b) {
        System.out.println("Number " + a + " contains more digits than number " + b + ".");
    }


    private static void printSecondGreaterResult(int a, int b) {
        System.out.println("Number " + a + " contains less digits than number " + b + ".");
    }


    private static void printEqualResult(int a, int b) {
        System.out.println("Number " + a + " and number " + b + " contain equal quantity of digits.");
    }


}
