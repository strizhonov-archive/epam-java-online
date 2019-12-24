package cycle;

import java.math.BigInteger;

/**
 * Составить программу нахождения произведения квадратов первых двухсот чисел.
 */

public class Fourth {

    public static void multiplySquares() {

        BigInteger bigInteger = new BigInteger("1");

        for (int i = bigInteger.intValue(); i <= 200; i++) {

            int square = (int) Math.pow(i, 2);
            bigInteger = bigInteger.multiply(BigInteger.valueOf(square));

        }

        System.out.println(bigInteger);
    }

}
