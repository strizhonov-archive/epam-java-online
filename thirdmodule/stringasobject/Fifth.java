package stringasobject;

/**
 * Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.
 */

public class Fifth {

    private static final char SYMBOL = 'a'; // latin а

    public static void countSymbol(String s) {

        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == SYMBOL) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}
