package fifth.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

    public static boolean checkForYesNoInput(String str) {
        Pattern pattern = Pattern.compile("[YNyn]");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean checkTypeInput(String str) {
        Pattern pattern = Pattern.compile("[1-3]");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean checkColorInput(String str) {
        Pattern pattern = Pattern.compile("[1-4]");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
