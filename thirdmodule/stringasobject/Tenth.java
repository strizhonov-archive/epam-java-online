package stringasobject;

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
