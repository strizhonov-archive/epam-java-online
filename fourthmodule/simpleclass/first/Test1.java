package simpleclass.first;

public class Test1 {

    private int a;
    private int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void printA() {
        System.out.println(a);
    }

    public void printB() {
        System.out.println(b);
    }

    public int sum() {
        return a + b;
    }

    public int max() {
        return Math.max(a, b);
    }
}
