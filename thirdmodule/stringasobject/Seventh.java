package stringasobject;

/**
 * Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
 * def", то должно быть выведено "abcdef".
 */

public class Seventh {

    public static void deleteDuplicates(String s) {

        StringBuilder updatedString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(i, i + 1);
            if (updatedString.indexOf(sub) == -1 && !" ".equals(sub)) {
                updatedString.append(sub);
            }
        }
        System.out.println(updatedString);
    }

}
