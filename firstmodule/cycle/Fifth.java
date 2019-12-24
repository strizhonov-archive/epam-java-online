package cycle;

/**
 * Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
 * заданному е. См. pdf файл.
 */

public class Fifth {

    public static void resolveSeries(double e, int length) {

        double sum = 0;
        double a;

        for (int i = 1; i <= length; i++) {
            a = 1 / Math.pow(2, i) + 1 / Math.pow(3, i);

            if (Math.abs(a) >= e) {
                sum += a;
            }

        }

        System.out.println(sum);
    }

}
