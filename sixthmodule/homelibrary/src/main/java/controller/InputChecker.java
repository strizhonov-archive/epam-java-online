package homelibrary.src.main.java.controller;

import homelibrary.src.main.java.Main;
import homelibrary.src.main.java.model.person.Person;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {

    public static boolean checkLogInMenuChoice(String input) {
        Pattern pattern = Pattern.compile("[1-3]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkForYesNoInput(String input) {
        Pattern pattern = Pattern.compile("[YNyn]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkLogin(String input) {
        if (input.length() < 4 || input.length() > 10) {
            return false;
        }

        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches() && !isLoginExists(input);
    }

    public static boolean checkPassword(String input) {
        return input.length() >= 4 && input.length() <= 10;
    }

    public static boolean checkEmail(String input) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@gmail.com$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches() && !isEmailExists(input);
    }

    public static boolean isLoginExists(String login) {
        ArrayList<Person> people = Main.personContainer.getPeople();
        for (Person person : people) {
            if (person.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmailExists(String email) {
        for (Person person : Main.personContainer.getPeople()) {
            if (person.getEMailAddress().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkUserMainDialogInput(String input) {
        Pattern pattern = Pattern.compile("[1-5]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkAdminMainDialogInput(String input) {
        Pattern pattern = Pattern.compile("[1-5]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkSearchDialogInput(String input) {
        Pattern pattern = Pattern.compile("[1-5]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkModificationDialogInput(String input) {
        Pattern pattern = Pattern.compile("[1-4]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkId(String id) {
        Pattern pattern = Pattern.compile("\\d{1,9}");
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public static boolean checkBookModificationInput(String input) {
        Pattern pattern = Pattern.compile("[1-4]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkBookTypeInput(String input) {
        Pattern pattern = Pattern.compile("[12]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkPageControlMenuInput(String input) {
        Pattern pattern = Pattern.compile("[12]");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
