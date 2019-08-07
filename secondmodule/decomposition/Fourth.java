package decomposition;

/**
 * На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
 * из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
 */

public class Fourth {

    public static void findMostRemotePoints(int[][] coordinates) {

        int firstPointIndex = 0;
        int secondPointIndex = 0;
        double maxDistance = 0;

        for (int i = 0; i < coordinates[0].length; i++) {
            for (int j = i + 1; j < coordinates[0].length; j++) {

                double distance = getDistance(coordinates[0][i], coordinates[1][i], coordinates[0][j], coordinates[1][j]);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    firstPointIndex = i;
                    secondPointIndex = j;
                }
            }
        }

        printResult(coordinates, firstPointIndex, secondPointIndex);

    }

    private static double getDistance(int xa, int ya, int xb, int yb) {
        return Math.sqrt(Math.pow(xb - xa, 2) + Math.pow(yb - ya, 2));
    }

    private static void printResult(int[][] coordinates, int firstPointIndex, int secondPointIndex) {
        System.out.println("The most remote points are A(" + coordinates[0][firstPointIndex] + ", "
                + coordinates[1][firstPointIndex] + ") and B(" + coordinates[0][secondPointIndex] + ", "
                + coordinates[1][secondPointIndex] + ").");
    }

}
