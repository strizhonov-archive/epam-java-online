package cycleprogram;

/**
 * Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.
 */

public class Eighth {

    public static void findDigitsAsNumbers(final int x, final int y) {

        // Creating new array with digits from two numbers
        int varX = x;
        int varY = y;
        int numLength = 0;

        while (varX != 0) {
            ++numLength;
            varX = varX / 10;
        }

        while (varY != 0) {
            ++numLength;
            varY = varY / 10;
        }

        int[] digits = new int[numLength];


        // Inflating array with digits
        varX = x;
        varY = y;
        numLength = 0;

        while (varX != 0) {
            digits[numLength++] = varX % 10;
            varX = varX / 10;
        }

        while (varY != 0) {
            digits[numLength++] = varY % 10;
            varY = varY / 10;
        }


        // Replacing duplicates with -1
        for (int i = digits.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (digits[i] == digits[j]) {
                    digits[j] = -1;
                }
            }
        }


        // Printing digits of two numbers
        System.out.println("Two numbers' digits are:");
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != -1) {
                System.out.print(digits[i] + " ");
            }
        }
        System.out.println();
    }
}
