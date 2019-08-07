package linearprogram;

/**
 * Вычислить значение выражени по формуле: ((b + sqrt(b^2 + 4ac)) / (2a - a^3 * c + b^(-2))
 */

public class Second {

    public static void resolvePowerFunction(int a, int b, int c) {

        double sumBeforeRooting = Math.pow(b, 2) + 4 * a * c;
        double numerator = b + Math.sqrt(sumBeforeRooting);
        double denominator = 2 * a;
        double firstAddend = numerator / denominator;

        double secondAddend = Math.pow(a, 3) * c;

        double thirdAddend = Math.pow(b, -2);

        double result = firstAddend - secondAddend + thirdAddend;

        System.out.println(result);
    }
}
