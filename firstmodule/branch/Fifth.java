package branch;

/**
 * Вычислить значение функции (см. pdf-файл).
 */

public class Fifth {

    public static void resolveFunction(int x) {

        double result;

        if (x <= 3) {
            result = Math.pow(x, 2) - 3 * x + 9;
        } else {
            result = 1 / (Math.pow(x, 3) + 6);
        }

        System.out.println(result);
    }

}
