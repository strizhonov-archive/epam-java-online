package simpleclass.fifth;

/**
 * Testing class
 */
public class Main {

    public static void main(String[] args) {
        Counter illegalCounter = new Counter(9, -1, 6);

        System.out.println(illegalCounter.getState());

        illegalCounter.decrease();

        illegalCounter.increase();

        System.out.println(illegalCounter.getState());

        illegalCounter.decrease();

        System.out.println(illegalCounter.getState());

    }

}
