package linearprogram;

public class Fourth {

    public static void switchDigits(double x) {

        int firstTriple = (int) x;

        int secondTriple = (int) (x * 1_000) - firstTriple * 1_000;

        double result = secondTriple + firstTriple / 1_000d;

        System.out.println(result);
    }

}
