package view;

import controller.InputChecker;
import Main;
import model.book.Book;
import model.person.Admin;

import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminView extends PersonView {

    private Admin admin;

    public AdminView(Admin admin) {
        super(admin);
        this.admin = admin;
    }

    public void showMainDialog() {
        Scanner sc = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("1 - View books.");
            System.out.println("2 - Search book.");
            System.out.println("3 - Modify catalog.");
            System.out.println("4 - Log out.");
            System.out.println("5 - Exit.");

            userInput = sc.nextLine();

            if (InputChecker.checkAdminMainDialogInput(userInput)) {
                adminMainAction(userInput);
            } else {
                AuxiliaryView.printWarning("Illegal input.");
            }

        } while (!"4".equals(userInput));

    }

    private void adminMainAction(String input) {
        switch (input) {
            case "1":
                pageControlMenu();
                break;
            case "2":
                showSearchDialog();
                break;
            case "3":
                showCatalogModificationDialog();
                break;
            case "5":
                System.exit(-1);
                break;
            case "4":
            default:
                break;
        }
    }

    private void showCatalogModificationDialog() {
        Scanner sc = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("1 - Add book.");
            System.out.println("2 - Modify book.");
            System.out.println("3 - Remove book.");
            System.out.println("4 - Back.");

            userInput = sc.nextLine();

            if (InputChecker.checkModificationDialogInput(userInput)) {
                catalogModificationAction(userInput);
            } else {
                AuxiliaryView.printWarning("Illegal input.");
            }

        } while (!"4".equals(userInput));

    }

    private void catalogModificationAction(String input) {
        switch (input) {
            case "1":
                Book book = createBookFromDialog();
                try {
                    admin.add(book);
                    AuxiliaryView.printMessage("The book successfully added.");
                } catch (IOException e) {
                    AuxiliaryView.printWarning("Unable to write book to file. " + e.getClass().getSimpleName());
                }
                break;
            case "2":
                bookModificationAction();
                break;
            case "3":
                long id = askId();
                if (Main.bookContainer.checkId(id)) {
                    try {
                        admin.remove(id);
                        AuxiliaryView.printMessage("The book successfully removed.");
                    } catch (IOException e) {
                        AuxiliaryView.printWarning("Unable to delete book from catalog. "
                                + e.getClass().getSimpleName());
                    }
                } else {
                    AuxiliaryView.printMessage("There is no book with such ID.");
                }

                break;
            case "4":
            default:
                break;
        }
    }

    private Book createBookFromDialog() {
        Scanner sc = new Scanner(System.in);

        AuxiliaryView.printMessage("Enter book name:");
        String name = sc.nextLine();

        AuxiliaryView.printMessage("Enter book author:");
        String author = sc.nextLine();

        String type;
        do {
            System.out.println("1 - Paper book.");
            System.out.println("2 - E-book.");

            type = sc.nextLine();
        } while (!InputChecker.checkBookTypeInput(type));

        boolean isPaper = "1".equals(type);

        AuxiliaryView.printMessage("Do you want to add description now? (y/n)");

        String userInput = sc.nextLine();

        while (!InputChecker.checkForYesNoInput(userInput)) {
            AuxiliaryView.printWarning("Illegal input.");
            AuxiliaryView.printMessage("Do you want to add description now? (y/n)");
            userInput = sc.nextLine();
        }

        Book book = Book.BookFactory.getBook(isPaper, name, author, Main.bookContainer.getNextId());

        if ("y".equals(userInput)) {
            try {
                String exitWord = "exit";
                AuxiliaryView.printMessage("Add book description here. When you finished, type \""
                        + exitWord + "\" from the new line.");
                String description = askDescription(exitWord);

                book = Book.BookFactory.getBook(isPaper, name, author, Main.bookContainer.getNextId(), description);


            } catch (IOException e) {
                AuxiliaryView.printWarning("Unable to set description. " + e.getClass().getSimpleName());
            }
        }
        return book;
    }

    private void bookModificationAction() {
        Scanner sc = new Scanner(System.in);

        long id = askId();

        if (currentUser.viewBookById(id)) {
            String userInput;
            do {
                System.out.println("1 - Change name.");
                System.out.println("2 - Change author.");
                System.out.println("3 - Change description.");
                System.out.println("4 - Back.");

                userInput = sc.nextLine();


                if (InputChecker.checkBookModificationInput(userInput)) {
                    modify(userInput, id);
                } else {
                    AuxiliaryView.printWarning("Illegal input.");
                }
            } while (!"4".equals(userInput));

        } else {
            AuxiliaryView.printMessage("No books with such ID.");
        }

    }

    private long askId() {
        Scanner sc = new Scanner(System.in);

        AuxiliaryView.printMessage("Enter book's ID:");
        String sId = sc.nextLine();

        while (!InputChecker.checkId(sId)) {
            AuxiliaryView.printWarning("Illegal input.");
            AuxiliaryView.printMessage("Enter book's ID:");
            sId = sc.nextLine();
        }

        return Long.parseLong(sId);
    }

    private void modify(String input, long id) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = Main.bookContainer.getBooks();
        switch (input) {
            case "1":
                for (Book book : books) {
                    if (book.getId() == id) {
                        AuxiliaryView.printMessage("Current name: \n" + book.getName());
                        AuxiliaryView.printMessage("Enter new name:");
                        book.setName(sc.nextLine());
                        try {
                            admin.reWriteCatalogFile();
                            AuxiliaryView.printMessage("The book successfully changed.");
                        } catch (IOException e) {
                            AuxiliaryView.printWarning("Unable to change name. " + e.getClass().getSimpleName());
                        }
                        break;
                    }
                }
                break;
            case "2":
                for (Book book : books) {
                    if (book.getId() == id) {
                        AuxiliaryView.printMessage("Current author: \n" + book.getAuthor());
                        AuxiliaryView.printMessage("Enter new author:");
                        book.setAuthor(sc.nextLine());
                        try {
                            admin.reWriteCatalogFile();
                            AuxiliaryView.printMessage("The book successfully changed.");
                        } catch (IOException e) {
                            AuxiliaryView.printWarning("Unable to change author. " + e.getClass().getSimpleName());
                        }
                        break;
                    }
                }
                break;
            case "3":
                for (Book book : books) {
                    if (book.getId() == id) {
                        if (book.getDescription() != null) {
                            AuxiliaryView.printMessage("Current description: \n" + book.getDescription());
                        } else {
                            AuxiliaryView.printMessage("There are no description.");
                        }
                        try {
                            String exitWord = "exit";
                            AuxiliaryView.printMessage("Add book description here. When you finished, type \""
                                    + exitWord + "\" from the new line.");
                            String description = askDescription(exitWord);

                            AuxiliaryView.printMessage("Enter your e-mail password to notify users " +
                                    "about adding the description:");
                            String eMailPass = sc.nextLine();

                            try {
                                admin.setDescription(description, book, eMailPass);
                            } catch (MessagingException e) {
                                AuxiliaryView.printWarning(e.getClass().getSimpleName()
                                        + ". Users wasn't notified about description.");
                            }
                            try {
                                admin.reWriteCatalogFile();
                                AuxiliaryView.printMessage("The book successfully changed.");
                            } catch (IOException e) {
                                AuxiliaryView.printWarning("Unable to change description. "
                                        + e.getClass().getSimpleName());
                            }
                        } catch (IOException e) {
                            AuxiliaryView.printWarning("Unable to change description. "
                                    + e.getClass().getSimpleName());
                        }
                        break;
                    }
                }
                break;
            case "4":
            default:
                break;
        }
    }

    private String askDescription(String exitWord) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        if (!str.equals(exitWord)) {
            sb.append(str);
            str = br.readLine();
        }

        while (!str.equals(exitWord)) {
            sb.append("\n")
                    .append(str);
            str = br.readLine();
        }

        return sb.toString();
    }

}
