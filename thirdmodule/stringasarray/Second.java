package stringasarray;

/**
 * Замените в строке все вхождения 'word' на 'letter'.
 */

public class Second {

    private static final String TO_REPLACE = "word";
    private static final String REPLACE_WITH = "letter";

    public static void replaceIn(String message) {

        char[] messageAsChar = toChar(message);

        String replacedMessage = replaceAllMatches(messageAsChar);

        print(replacedMessage);
    }


    private static char[] toChar(String text) {
        char[] messageAsChar = new char[text.length()];

        for (int i = 0; i < messageAsChar.length; i++) {
            messageAsChar[i] = text.charAt(i);
        }

        return messageAsChar;
    }


    private static String replaceAllMatches(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            int startIndex = indexOf(TO_REPLACE, chars);
            if (startIndex == -1) {
                break;
            } else {
                chars = replace(chars, REPLACE_WITH, startIndex, TO_REPLACE.length());
            }
        }
        return new String(chars);
    }


    private static int indexOf(String text, char[] array) {

        for (int i = 0; i < array.length - text.length() + 1; i++) {
            boolean isThereAWord = true;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) != array[i + j]) {
                    isThereAWord = false;
                    break;
                }
            }
            if (isThereAWord) {
                return i;
            }
        }
        return -1;
    }

    private static char[] replace(char[] array, String replaceWith, int startIndex, int lengthToBeReplaced) {
        char[] newArray = new char[array.length + replaceWith.length() - lengthToBeReplaced];

        for (int newArrayIndex = 0, oldArrayIndex = 0; newArrayIndex < newArray.length; newArrayIndex++, oldArrayIndex++) {
            if (newArrayIndex == startIndex) {

                for (int j = 0; j < replaceWith.length(); j++, newArrayIndex++) {
                    newArray[newArrayIndex] = replaceWith.charAt(j);
                }

                oldArrayIndex += lengthToBeReplaced;
                newArrayIndex--;
                oldArrayIndex--;

            } else {
                newArray[newArrayIndex] = array[oldArrayIndex];
            }

        }

        return newArray;
    }


    private static void print(String s) {
        System.out.println(s);
    }

}
