package notebook.Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

    public static boolean checkMainMenuInput(String input) {
        Pattern pattern = Pattern.compile("[1-4]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkSearchMenuInput(String input) {
        Pattern pattern = Pattern.compile("[1-6]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkDateInput(String input) {
        Pattern pattern = Pattern.compile("^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
                + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
                + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
                + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkEmailInput(String input) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
