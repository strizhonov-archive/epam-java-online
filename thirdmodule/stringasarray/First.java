package stringasarray;

/**
 * Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 */

public class First {

    public static void convertCamelToSnake(String[] camelArray) {
        for (int i = 0; i < camelArray.length; i++) {
            String snakeLexeme =  getSnakeFrom(camelArray[i]);
            print(snakeLexeme, i);
        }
    }


    private static String getSnakeFrom(String s) {

        char[] camelChars = toChar(s);

        camelChars = underscore(camelChars);

        toLowerCase(camelChars);

        return new String(camelChars);
    }


    private static char[] toChar(String s) {
        char[] result = new char[s.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = s.charAt(i);
        }

        return result;
    }


    private static char[] underscore(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars = insertUnderscoreAt(i, chars);
                i++;
            }
        }
        return chars;
    }


    private static char[] insertUnderscoreAt(int a, char[] array) {
        char[] newArray = new char[array.length + 1];
        for (int i = 0, initialArrayIndex = 0; i < newArray.length; i++, initialArrayIndex++) {
            if (a == i) {
                newArray[i] = '_';
                initialArrayIndex--;
            } else {
                newArray[i] = array[initialArrayIndex];
            }

        }
        return newArray;
    }


    private static void toLowerCase(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] += 32;
            }
        }
    }


    private static void print(String snakeLexeme, int number) {
        System.out.println(number + 1 + ": " + snakeLexeme);
    }
}
