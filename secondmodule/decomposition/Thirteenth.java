package decomposition;

/**
 * Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
 * Найти и напечатать все пары «близнецов» из отрезка [n, 2n], где n - заданное натуральное число больше 2. Для
 * решения задачи использовать декомпозицию.
 */

public class Thirteenth {

    public static void findTwins(int n) {

        for (int i = n; i <= 2 * n; i++) {
            if (checkIfNumberIsPrime(i)) {
                if (checkIfNumberIsPrime(i + 2)) {
                    printResult(i, i + 2);
                }
            }
        }

    }

    private static boolean checkIfNumberIsPrime(int number) {

        boolean isNumberPrime = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isNumberPrime = false;
            }
        }
        return isNumberPrime;
    }

    private static void printResult(int firstElement, int secondElement) {
        System.out.println("Twin prime pair: " + firstElement + ", " + secondElement + "");
    }

}
