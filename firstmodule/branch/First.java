package branch;

/**
 * Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
 * он прямоугольным.
 */

public class First {

    public static void checkValidityOfTriangle(double x, double y) {

        if (x > 0 && y > 0 && x < 180 && y < 180 && (x + y) < 180) {
            System.out.println("Triangle can exist.");

            if (x == 90 || y == 90 || x + y == 90) {
                System.out.println("Triangle is right.");
            } else {
                System.out.println("Triangle is not right.");
            }

        } else {
            System.out.println("Triangle can not exist.");
        }
    }
}
