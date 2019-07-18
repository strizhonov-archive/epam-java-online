package stringasobject;

public class Ninth {

    public static void splitLettersByCase(String s) {
        int upperCased = 0;
        int lowerCased = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentSymbol = s.charAt(i);
            if (currentSymbol >= 'a' && currentSymbol <= 'z') {
                lowerCased++;
            }
            if (currentSymbol >= 'A' && currentSymbol <= 'Z') {
                upperCased++;
            }
        }

        System.out.println("Lowercased letters: " + lowerCased);
        System.out.println("Uppercased letters: " + upperCased);
    }
}
