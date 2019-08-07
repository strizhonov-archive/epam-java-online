package view;

import controller.InputChecker;
import model.book.BookTemplate;
import model.person.User;

import javax.mail.MessagingException;
import java.util.Scanner;

public class UserView extends PersonView {

    private User user;

    public UserView(User user) {
        super(user);
        this.user = user;
    }

    public void showMainDialog() {
        Scanner sc = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("1 - View books.");
            System.out.println("2 - Search a book.");
            System.out.println("3 - Suggest a book to admins.");
            System.out.println("4 - Log out.");
            System.out.println("5 - Exit.");

            userInput = sc.nextLine();

            if (InputChecker.checkUserMainDialogInput(userInput)) {
                userMainAction(userInput);
            } else {
                AuxiliaryView.printWarning("Illegal input.");
            }

        } while (!"4".equals(userInput));

    }

    private void userMainAction(String input) {
        switch (input) {
            case "1":
                pageControlMenu();
                break;
            case "2":
                showSearchDialog();
                break;
            case "3":
                showBookSuggestionDialog();
                break;
            case "5":
                System.exit(-1);
                break;
            case "4":
            default:
                break;
        }
    }

    private void showBookSuggestionDialog() {
        Scanner sc = new Scanner(System.in);

        AuxiliaryView.printMessage("Enter book name:");
        String name = sc.nextLine();

        AuxiliaryView.printMessage("Enter book author:");
        String author = sc.nextLine();

        AuxiliaryView.printMessage("Enter your e-mail password:");
        String password = sc.nextLine();
        try {
            user.suggest(new BookTemplate(name, author), password);
        } catch (MessagingException e) {
            AuxiliaryView.printWarning(e.getClass().getSimpleName() + ". Suggestion hasn't sent.");
        }

    }

}
