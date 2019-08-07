package stringasarray;

/**
 * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
 * Крайние пробелы в строке удалить.
 */

public class Fifth {

    public static void trim(String message) {

        char[] cMessage = toChar(message);

        cMessage = deleteDupleSpaces(cMessage);
        cMessage = trim(cMessage);
        printResult(cMessage);

    }


    private static char[] toChar(String text) {
        char[] messageAsChar = new char[text.length()];

        for (int i = 0; i < messageAsChar.length; i++) {
            messageAsChar[i] = text.charAt(i);
        }

        return messageAsChar;
    }


    private static char[] deleteDupleSpaces(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == ' ' && arr[i + 1] == ' ') {
                arr = deleteElement(i, arr);
                i--;
            }
        }
        return arr;
    }


    private static char[] deleteElement(int index, char[] arr) {
        char[] updArr = new char[arr.length - 1];
        for (int arrIndex = 0, updArrIndex = 0; arrIndex < arr.length; arrIndex++, updArrIndex++) {
            if (arrIndex != index) {
                updArr[updArrIndex] = arr[arrIndex];
            } else {
                updArrIndex--;
            }

        }
        return updArr;
    }


    private static char[] trim(char[] arr) {
        if (arr[0] == ' ') {
            arr = deleteElement(0, arr);
        }
        if (arr[arr.length - 1] == ' ') {
            arr = deleteElement(arr.length - 1, arr);
        }
        return arr;
    }


    private static void printResult(char[] c) {
        System.out.println(new String(c));
    }
}
