package branch;

/**
 * Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.
 */

public class Third {

    public static void checkIfCoordinatesAreInLine(int ax, int ay, int bx, int by, int cx, int cy) {

        //Vector AB data
        int abx = bx - ax;
        int aby = by - ay;

        //Vector AC data
        int acx = cx - ax;
        int acy = cy - ay;

        boolean areVectorsCollinear;
        if (acx == 0 || acy == 0) {
            areVectorsCollinear = (abx == 0 && acx == 0)
                    || (aby == 0 && acy == 0)
                    || (acx == 0 && acy == 0);
        } else {
            areVectorsCollinear = ((double) abx / acx == (double) aby / acy);
        }

        if (areVectorsCollinear) {
            System.out.println("Coordinates are in one line.");
        } else {
            System.out.println("Coordinates are not in one line.");
        }
    }
}
