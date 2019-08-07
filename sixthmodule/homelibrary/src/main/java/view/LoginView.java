package homelibrary.src.main.java.view;

import homelibrary.src.main.java.Main;
import homelibrary.src.main.java.controller.InputChecker;
import homelibrary.src.main.java.model.PersonContainer;
import homelibrary.src.main.java.model.person.Person;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class LoginView {

    private Person currentPerson;

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void showLogInMenu(){
        Scanner sc = new Scanner(System.in);

        boolean quitMenu = false;
        while (!quitMenu) {
            System.out.println("1 - Sign In");
            System.out.println("2 - Sign Up");
            System.out.println("3 - Exit.");

            String userInput = sc.nextLine();

            if (InputChecker.checkLogInMenuChoice(userInput)) {
                quitMenu = loginMainAction(userInput);
            } else {
                AuxiliaryView.printWarning("Illegal input.");
            }
        }
    }

    private boolean loginMainAction(String input) {
        switch (input) {
            case "1":
                return signIn();
            case "2":
                signUp();
                return false;
            case "3":
                System.exit(-1);
                return false;
            default:
                return false;
        }
    }

    private boolean signIn() {
        String login = askLogin();
        String password = askPassword();

        currentPerson = new PersonContainer().getPerson(login, password);
        if (currentPerson != null) {
            return true;
        } else {
            AuxiliaryView.printMessage("Wrong login or password.");
            return false;
        }
    }

    private void signUp() {
        boolean isAdmin = askForAdminCreation();
        String login = askNewLogin();
        String password = askNewPassword();
        String repeatedPassword = askToRepeatPassword();

        if (password != null && password.equals(repeatedPassword)) {
            String eMail = askEMail();

            try {
                currentPerson = Person.PersonFactory.getPerson(isAdmin, login, password, eMail);
                currentPerson.write();
                Main.personContainer.getPeople().add(currentPerson);
                currentPerson = null;
            } catch (IOException e) {
                AuxiliaryView.printWarning("Unable to create user.");
            }

        } else {
            AuxiliaryView.printMessage("Passwords do not match.");
        }

    }

    private String askPassword() {
        Scanner sc = new Scanner(System.in);

        AuxiliaryView.printMessage("Enter password:");

        Console c = System.console();

        String password;
        if (c == null) {
            password = sc.nextLine();
        } else {
            char[] ch = c.readPassword();
            password = String.valueOf(ch);
        }

        return password;
    }

    private String askLogin() {
        Scanner sc = new Scanner(System.in);

        AuxiliaryView.printMessage("Enter your login:");
        return sc.nextLine();
    }

    private String askEMail() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            AuxiliaryView.printMessage("Enter your e-mail (at gmail.com):");
            String userInput = sc.nextLine();

            if (InputChecker.checkEmail(userInput)) {
                return userInput;
            } else {
                AuxiliaryView.printMessage("Choose another e-mail.");
            }
        }
    }

    private boolean askForAdminCreation() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            AuxiliaryView.printMessage("Do you want to create admin account? (y/n)");

            String userInput = sc.nextLine();

            if (InputChecker.checkForYesNoInput(userInput)) {
                if ("y".equals(userInput)) {
                    String enteredAdminPassword = askAdminPassword();

                    if (Main.getAdminCreationPassword().equals(enteredAdminPassword)) {
                        AuxiliaryView.printMessage("You can create admin account now.");
                        return true;
                    } else {
                        AuxiliaryView.printMessage("Wrong password.");
                    }

                } else {
                    return false;
                }
            } else {
                AuxiliaryView.printWarning("Illegal input.");
            }
        }

    }

    private String askAdminPassword() {
        Scanner sc = new Scanner(System.in);

        AuxiliaryView.printMessage("Enter admin access password:");

        Console c = System.console();

        String password;
        if (c == null) {
            password = sc.nextLine();
        } else {
            char[] ch = c.readPassword();
            password = String.valueOf(ch);
        }

        return password;
    }

    private String askNewLogin() {
        Scanner sc = new Scanner(System.in);

        AuxiliaryView.printMessage("Enter login (4 to 10 letters or digits):");
        while (true) {

            String userInput = sc.nextLine();

            if (InputChecker.checkLogin(userInput)) {
                return userInput;
            } else {
                AuxiliaryView.printMessage("Choose another login.");
            }
        }
    }

    private String askNewPassword() {
        Scanner sc = new Scanner(System.in);

        AuxiliaryView.printMessage("Enter password (4 to 10 letters or digits):");
        while (true) {
            Console c = System.console();

            String userInput;
            if (c == null) {
                userInput = sc.nextLine();
            } else {
                char[] ch = c.readPassword();
                userInput = String.valueOf(ch);
            }

            if (InputChecker.checkPassword(userInput)) {
                return userInput;
            } else {
                AuxiliaryView.printMessage("Choose another password. It should contain from 4 to 10 symbols.");
            }
        }
    }

    private String askToRepeatPassword() {
        Scanner sc = new Scanner(System.in);

        AuxiliaryView.printMessage("Please, re-enter password:");

        Console c = System.console();

        String password;
        if (c == null) {
            password = sc.nextLine();
        } else {
            char[] ch = c.readPassword();
            password = String.valueOf(ch);
        }

        return password;
    }

}
