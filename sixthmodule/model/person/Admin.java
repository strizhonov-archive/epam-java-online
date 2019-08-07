package model.person;

import Main;
import controller.SaverLoader;
import model.book.Book;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;

public class Admin extends Person {

    public Admin(String login, String password, String eMailAddress) {
        super(login, password, eMailAddress);
    }

    public void add(Book book) throws IOException {
        Main.bookContainer.getBooks().add(book);
        SaverLoader.writeBook(book);
    }

    public void remove(long id) throws IOException {
        ArrayList<Book> books = Main.bookContainer.getBooks();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                reWriteCatalogFile();
                break;
            }
        }
    }

    public void reWriteCatalogFile() throws IOException {
        SaverLoader.reWriteBooks();
    }

    public void setDescription(String description, Book book, String eMailPass) throws MessagingException {
        book.setDescription(description, this, eMailPass);
    }

}
