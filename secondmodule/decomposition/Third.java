package decomposition;

/**
 * Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
 * треугольника.
 */

public class Third {

    public static void printRegularHexagonArea(int side) {
        double area = getRegularTriangleArea(side) * 6;
        printResult(side, area);
    }

    private static double getRegularTriangleArea(int side) {
        return side * side * Math.sqrt(3) / 4;
    }

    private static void printResult(int side, double area) {
        System.out.println("Square of hexagon with side " + side + " is " + area + ".");
    }
}
