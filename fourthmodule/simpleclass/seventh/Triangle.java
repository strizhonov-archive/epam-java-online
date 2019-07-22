package simpleclass.seventh;

public class Triangle {

    private Coordinate a;
    private Coordinate b;
    private Coordinate c;

    public Triangle(Coordinate a, Coordinate b, Coordinate c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {

        double ab = Coordinate.getDistance(a, b);
        double bc = Coordinate.getDistance(b, c);
        double ca = Coordinate.getDistance(c, a);

        double halfP = (ab + bc + ca) / 2;

        return Math.sqrt(halfP * (halfP - ab) * (halfP - bc) * (halfP - ca));
    }

    public double getPerimeter() {
        double ab = Coordinate.getDistance(a, b);
        double bc = Coordinate.getDistance(b, c);
        double ca = Coordinate.getDistance(c, a);

        return ab + bc + ca;
    }

    public Coordinate getCentriod() {
        double oX = a.getX() + b.getX() + c.getX() / 3;
        double oY = a.getY() + b.getY() + c.getY() / 3;
        return new Coordinate(oX, oY);
    }
}


