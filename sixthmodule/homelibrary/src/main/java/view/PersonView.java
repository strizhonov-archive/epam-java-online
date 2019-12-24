package homelibrary.src.main.java.view;

import homelibrary.src.main.java.controller.InputChecker;
import homelibrary.src.main.java.model.person.Person;

import java.util.Scanner;

public class PersonView {

    protected Person currentUser;

    public PersonView(Person person) {
        this.currentUser = person;
    }

    protected void showSearchDialog() {
        Scanner sc = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("1 - Search by id.");
            System.out.println("2 - Search by name.");
            System.out.println("3 - Search by author.");
            System.out.println("4 - Back.");
            System.out.println("5 - Exit.");

            userInput = sc.nextLine();

            if (InputChecker.checkSearchDialogInput(userInput)) {
                searchAction(userInput);
            } else {
                AuxiliaryView.printWarning("Illegal input.");
            }

        } while (!"4".equals(userInput));

    }

    protected void pageControlMenu() {
        CatalogPageView cpv = new CatalogPageView();
        Scanner sc = new Scanner(System.in);

        boolean isAllCatalogPrinted = currentUser.viewBooksByPage(cpv, true);

        String userInput = null;
        while (!isAllCatalogPrinted && !"2".equals(userInput)) {
            System.out.println("1 - Next page.");
            System.out.println("2 - Back to menu.");

            userInput = sc.nextLine();

            if (InputChecker.checkPageControlMenuInput(userInput)) {
                if ("1".equals(userInput)) {
                    isAllCatalogPrinted = currentUser.viewBooksByPage(cpv, false);
                }
            } else {
                AuxiliaryView.printWarning("Illegal input.");
            }
        }

        if (isAllCatalogPrinted) {
            AuxiliaryView.printMessage("End of the catalog.");
        }

    }

    private void searchAction(String input) {
        switch (input) {
            case "1":
                Scanner sc = new Scanner(System.in);

                AuxiliaryView.printMessage("Enter book id:");

                String userInput;
                userInput = sc.nextLine();

                while (!InputChecker.checkId(userInput)) {
                    AuxiliaryView.printWarning("Illegal input.");
                    userInput = sc.nextLine();
                }

                if (!currentUser.viewBookById(Long.parseLong(userInput))) {
                    AuxiliaryView.printMessage("No books found.");
                }

                break;
            case "2":
                sc = new Scanner(System.in);

                AuxiliaryView.printMessage("Enter book name:");
                userInput = sc.nextLine();

                if (!currentUser.viewBooksByName(userInput)) {
                    AuxiliaryView.printMessage("No books found.");
                }

                break;
            case "3":
                sc = new Scanner(System.in);

                AuxiliaryView.printMessage("Enter book author:");
                userInput = sc.nextLine();

                if (!currentUser.viewBooksByAuthor(userInput)) {
                    AuxiliaryView.printMessage("No books found.");
                }

                break;
            case "5":
                System.exit(-1);
                break;
            case "4":
            default:
                break;
        }
    }

}
