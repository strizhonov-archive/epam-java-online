package stringasobject;

/**
 * Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
 * знаком. Определить количество предложений в строке X.
 */

public class Tenth {

    public static void countSentences(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (".".equals(sub) || "!".equals(sub) || "?".equals(sub)) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
