package linear;

/**
 * Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
 * дробную и целую части числа и вывести полученное значение числа.
 */

public class Fourth {

    public static void switchDigits(double x) {

        int firstTriple = (int) x;

        int secondTriple = (int) (x * 1_000) - firstTriple * 1_000;

        double result = secondTriple + firstTriple / 1_000d;

        System.out.println(result);
    }

}
