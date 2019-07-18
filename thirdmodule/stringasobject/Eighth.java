package stringasobject;

public class Eighth {

    public static void printTheLongestWord(String s) {
        String[] words = s.split(" ");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println(longestWord);
    }

}
