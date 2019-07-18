package linearprogram;

public class Sixth {

    public static void checkValidityOfCoordinates(int x, int y) {

        boolean isPointInsideArea = !(Math.abs(x) > 4 || y > 4 || y < -3 || (Math.abs(x) > 2 && y > 0));

        System.out.println(isPointInsideArea);
    }

}
