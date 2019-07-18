package decomposition;

import java.text.DecimalFormat;

public class Ninth {

    public static void findQuadrilateralArea(double firstRightSide, double secondRightSide,
                                             double thirdSide, double fourthSide) {

        if (checkIfDataValid(firstRightSide, secondRightSide, thirdSide, firstRightSide)) {

            double rightTriangleArea = getRightTriangleArea(firstRightSide, secondRightSide);

            double hypotenuse = getHypotenuse(firstRightSide, secondRightSide);
            double simpleTriangleArea = getSimpleTriangleArea(hypotenuse, thirdSide, fourthSide);

            double quadrilateralArea = rightTriangleArea + simpleTriangleArea;

            printArea(quadrilateralArea);

        } else {

            printWarning("Quadrilateral with passed data can not exist.");
        }

    }

    private static boolean checkIfDataValid(double firstRightSide, double secondRightSide,
                                            double thirdSide, double fourthSide) {

        boolean isAllSidesGreaterThanZero = firstRightSide > 0 && secondRightSide > 0 && thirdSide > 0 && fourthSide > 0;

        double diagonal = getHypotenuse(firstRightSide, secondRightSide);

        boolean doSimpleTriangleExist = thirdSide + fourthSide > diagonal
                && fourthSide + diagonal > thirdSide
                && diagonal + thirdSide > fourthSide;

        return isAllSidesGreaterThanZero && doSimpleTriangleExist;

    }


    private static double getRightTriangleArea(double firstCathetus, double secondCathetus) {
        return firstCathetus * secondCathetus / 2;
    }


    private static double getHypotenuse(double firstCathetus, double secondCathetus) {
        return Math.sqrt(firstCathetus * firstCathetus + secondCathetus * secondCathetus);
    }


    private static double getSimpleTriangleArea(double firstSide, double secondSide, double thirdSide) {

        double halfPerimeter = (firstSide + secondSide + thirdSide) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - firstSide)
                * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide));

    }


    private static void printWarning(String message) {
        System.out.println(message);
    }


    private static void printArea(double area) {
        DecimalFormat format = new DecimalFormat("##.00");
        System.out.println("Area of quadrilateral is " + format.format(area) + ".");
    }

}
