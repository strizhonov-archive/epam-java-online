package simpleclass.seventh;

/**
 * Testing class
 */
public class Main {

    public static void main(String[] args) {

        Triangle triangle = new Triangle(
                new Coordinate(0, 0),
                new Coordinate(0, 4),
                new Coordinate(2, 0)
        );

        System.out.println(triangle.getArea());
        System.out.println(triangle.getCentriod());
        System.out.println(triangle.getPerimeter());

    }

}
