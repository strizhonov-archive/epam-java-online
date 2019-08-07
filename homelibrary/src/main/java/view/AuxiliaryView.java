package src.main.java.view;

public class AuxiliaryView {

    private static final String DIVIDER_CHARACTER = "*";

    public static void printWarning(String warning) {
        System.out.println("Warning: " + warning);
    }

    public static void printMessage(String message) {
        String divider = DIVIDER_CHARACTER.repeat(message.length());
        System.out.println(divider);
        System.out.println(message);
        System.out.println(divider);
    }
}
