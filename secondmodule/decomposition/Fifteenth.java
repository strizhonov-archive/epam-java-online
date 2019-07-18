package decomposition;

public class Fifteenth {

    public static void findAscending(int n) {
        if (n < 1 || n > 9) {
            printWarning("Illegal income data.");
        } else {
            int min = getMin(n);
            int max = getMax(n);
            for (int i = min; i <= max; i++) {
                if (areAllDigitsAscending(i)) {
                    printResult(i);
                }
            }
        }
    }

    private static void printWarning(String warningMessage) {
        System.out.println(warningMessage);
    }

    private static int getMax(int numberLength) {
        int max = 0;
        for (int i = 9; i > 9 - numberLength; i--) {
            max += i;
            max *= 10;
        }
        return max;
    }

    private static boolean areAllDigitsAscending(int number) {
        int previousDigit = 10;
        while (number != 0) {
            if (number % 10 >= previousDigit) {
                return false;
            } else {
                previousDigit = number % 10;
                number = number / 10;
            }
        }
        return true;
    }

    private static int getMin(int numberLength) {
        int min = 0;
        for (int i = 1; i <= numberLength; i++) {
            min *= 10;
            min += i;
        }
        return min;
    }

    private static void printResult(int number) {
        System.out.println("Number " + number + " has ascending digits.");
    }
}
