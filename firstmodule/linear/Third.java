package linear;

/**
 * Вычислить значение выражени по формуле: (sin(x) + cos(y) / cos(x) - sin(y)) * tg(xy)
 */

public class Third {

    // X, Y supposed to be RADIANS
    public static void resolveTrigonometricFunction(int x, int y) {

        double numerator = Math.sin(x) + Math.cos(y);
        double denominator = Math.cos(x) - Math.sin(y);
        double multiplier = Math.tan(x * y);

        double result = (numerator / denominator) * multiplier;

        System.out.println(result);
    }

}
