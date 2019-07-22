package simpleclass.seventh;

public class Coordinate {

    private double x;
    private double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static double getDistance(Coordinate a, Coordinate b) {
        double d = Math.pow(a.getX() - b.getX(), 2);
        double e = Math.pow(a.getY() - b.getY(), 2);

        return Math.sqrt(d + e);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
