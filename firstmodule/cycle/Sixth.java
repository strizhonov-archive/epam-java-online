package cycle;

/**
 * Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
 */

public class Sixth {

    public static void printChars() {

        for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
            System.out.println((char) i + " = " + i);
        }

    }
}
