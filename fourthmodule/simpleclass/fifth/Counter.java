package simpleclass.fifth;

public class Counter {

    private int state = 0;
    private int lowerBound = 0;
    private int upperBound = 100;

    public Counter() {
    }

    public Counter(int state, int lowerBound, int upperBound) {
        if (upperBound < lowerBound || state < lowerBound || state > upperBound) {
            System.out.println("Illegal data. Creating default object.");
        } else {
            this.state = state;
            this.upperBound = upperBound;
            this.lowerBound = lowerBound;
        }
    }

    public int getState() {
        return state;
    }

    public void increase() {
        if (state < upperBound) {
            System.out.println("Increasing...");
            state++;
        } else {
            System.out.println("Upper bound reached.");
        }
    }

    public void decrease() {
        if (state > lowerBound) {
            System.out.println("Decreasing...");
            state--;
        } else {
            System.out.println("Lower bound reached.");
        }
    }

}
