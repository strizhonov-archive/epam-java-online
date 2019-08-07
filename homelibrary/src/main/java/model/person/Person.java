package model.person;

import Main;
import controller.SaverLoader;
import model.book.Book;
import view.CatalogPageView;

import java.io.IOException;

public class Person {

    private String login;
    private String password;
    private String eMailAddress;

    public Person(String login, String password, String eMailAddress) {
        this.login = login;
        this.password = password;
        this.eMailAddress = eMailAddress;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEMailAddress() {
        return eMailAddress;
    }

    public void write()throws IOException {
        SaverLoader.writePerson(this);
    }

    public boolean viewBooksByPage(CatalogPageView cpv, boolean fromStart) {
        return cpv.view(fromStart);
    }

    public boolean viewBooksByAuthor(String author) {
        boolean isAnyBookFound = false;
        if (Main.bookContainer.getBooks().size() > 0) {
            for (Book book : Main.bookContainer.getBooks()) {
                if (author.equals(book.getAuthor())) {
                    System.out.println(book);
                    isAnyBookFound = true;
                }
            }
        }
        return isAnyBookFound;
    }

    public boolean viewBooksByName(String name) {
        boolean isAnyBookFound = false;
        if (Main.bookContainer.getBooks().size() > 0) {
            for (Book book : Main.bookContainer.getBooks()) {
                if (name.equals(book.getName())) {
                    System.out.println(book);
                    isAnyBookFound = true;
                }
            }
        }
        return isAnyBookFound;
    }

    public boolean viewBookById(long id) {
        boolean isAnyBookFound = false;
        if (Main.bookContainer.getBooks().size() > 0) {
            for (Book book : Main.bookContainer.getBooks()) {
                if (book.getId() == id) {
                    System.out.println(book);
                    isAnyBookFound = true;
                }
            }
        }
        return isAnyBookFound;
    }

    public static class PersonFactory {

        public static Person getPerson(boolean isAdmin,
                                       String login,
                                       String password,
                                       String eMailAddress) {
            return isAdmin
                    ? new Admin(login, password, eMailAddress)
                    : new User(login, password, eMailAddress);
        }

    }

}
