package decomposition;

/**
 * Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 */

public class Sixteenth {

    public static void findSumByRule(int n) {
        if (n < 1) {
            printWarning("Illegal income data.");
        } else {
            int min = getMin(n);
            int max = getMax(n);
            int sum = 0;
            for (int i = min; i <= max; i++) {
                if (checkIfNumberHasOnlyOddDigits(i)) {
                    sum += i;
                }
            }

            int even = countEvenDigits(sum);
            printResult(sum, even);
        }

    }

    private static int countEvenDigits(int number) {
        int count = 0;
        while (number != 0) {
            if ((number % 10) % 2 == 0) {
                count++;
            }
            number /= 10;

        }
        return count;
    }

    private static boolean checkIfNumberHasOnlyOddDigits(int number) {
        while (number != 0) {
            if ((number % 10) % 2 == 0) {
                return false;
            } else {
                number /= 10;
            }
        }
        return true;
    }

    private static int getMin(int numberLength) {
        return (int)Math.pow(10, numberLength - 1);
    }

    private static int getMax(int numberLength) {
        int max = 9;
        for (int i = 0; i < numberLength - 1; i++) {
            max *= 10;
            max += 9;
        }
        return max;
    }

    private static void printWarning(String warningMessage) {
        System.out.println(warningMessage);
    }

    private static void printResult(int number, int evenDigitsCount) {
        System.out.println("Sum is " + number + ", even digits " + evenDigitsCount);
    }

}
