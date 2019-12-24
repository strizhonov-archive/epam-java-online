package branch;

/**
 * Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
 * отверстие.
 */

public class Fourth {

    public static void checkIfBrickFits(int a, int b, int x, int y, int z) {

        if (a <= 0 || b <= 0 || x <= 0 || y <= 0 || z <= 0) {
            System.out.println("Coordinates are invalid");

        } else {
            boolean isBrickFits = (((x < a) && (y < b)) || ((x < a) && (z < b))
                    || ((y < a) && (z < b)) || ((y < a) && (x < b))
                    || ((z < a) && (x < b)) || ((z < a) && (y < b)));

            if (isBrickFits) {
                System.out.println("The brick can be passed through the hole");
            } else {
                System.out.println("The brick can't be passed through the hole");
            }

        }

    }

}
