package decomposition;

/**
 * Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
 * возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
 * использовать декомпозицию.
 */

public class Fourteenth {


    public static void findArmstrongTo(int k) {

        for (int i = 1; i <= k; i++) {
            int digitsCount = getDigitsCount(i);
            int sum = getSumOfPoweredDigits(i, digitsCount);
            if (i == sum) {
                printResult(i);
            }
        }

    }


    private static int getDigitsCount(int number) {
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;

        }
        return count;
    }


    private static int getSumOfPoweredDigits(int number, int power) {
        int sum = 0;
        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, power);
            number = number / 10;

        }
        return sum;
    }


    private static void printResult(int armstrongValue) {
        System.out.println(armstrongValue + " is an Armstrong value.");
    }

}
