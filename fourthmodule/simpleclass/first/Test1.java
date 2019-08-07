package simpleclass.first;

/**
 * Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
 * переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
 * наибольшее значение из этих двух переменных.
 */

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
