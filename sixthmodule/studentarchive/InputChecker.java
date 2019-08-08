package studentarchive;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

    public static boolean checkMainMenuInput(String input) {
        Pattern pattern = Pattern.compile("[1-4]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkNumInput(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
