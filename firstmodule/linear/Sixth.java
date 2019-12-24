package linear;

/**
 * Для области, указанной в pdf-файле составить линейную программу, которая печатает true, если точка с координатами (х, у)
 * принадлежит закрашенной области, и false — в противном случае.
 */

public class Sixth {

    public static void checkValidityOfCoordinates(int x, int y) {

        boolean isPointInsideArea = !(Math.abs(x) > 4 || y > 4 || y < -3 || (Math.abs(x) > 2 && y > 0));

        System.out.println(isPointInsideArea);
    }

}
