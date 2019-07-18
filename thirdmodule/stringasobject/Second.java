package stringasobject;

public class Second {

    private static final char FLAG_CHAR = 'a';
    private static final char TO_INSERT = 'b';

    public static void insertSymbol(String s) {
        String[] splitted = s.split(String.valueOf(FLAG_CHAR));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < splitted.length - 1; i++) {
            stringBuilder.append(splitted[i])
                    .append(FLAG_CHAR)
                    .append(TO_INSERT);
        }

        stringBuilder.append(splitted[splitted.length - 1]);

        System.out.println(stringBuilder);
    }

}
