package stringasobject;

/**
 * Проверить, является ли заданное слово палиндромом.
 */

public class Third {

    public static void checkIfWordIsPalindrome(String s) {

        s = s.toLowerCase();
        StringBuilder firstHalf = new StringBuilder(s.substring(0, s.length() / 2));
        StringBuilder secondHalf = new StringBuilder(s.substring(s.length() / 2 + 1));


        if (firstHalf.toString().equals(secondHalf.reverse().toString())) {
            System.out.println("Слово является палиндромом");
        } else {
            System.out.println("Слово не является палиндромом");
        }
    }
}
