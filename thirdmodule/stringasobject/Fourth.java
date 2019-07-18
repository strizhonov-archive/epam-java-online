package stringasobject;

public class Fourth {

    private static final String INITIAL_WORD = "информатика";

    public static void transformWord() {

        char[] stringAsChar = INITIAL_WORD.toCharArray();

        String result = String.copyValueOf(stringAsChar, findIndex(stringAsChar, 'т'), 1)
                + String.copyValueOf(stringAsChar, findIndex(stringAsChar, 'о'), 1)
                + String.copyValueOf(stringAsChar, findIndex(stringAsChar, 'р'), 1)
                + String.copyValueOf(stringAsChar, findIndex(stringAsChar, 'т'), 1);
        System.out.println(result);

    }

    private static int findIndex(char[] arr, char c) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == c) {
                return i;
            }
        }
        return -1;
    }
}
