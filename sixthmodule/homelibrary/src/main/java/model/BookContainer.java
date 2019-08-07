package homelibrary.src.main.java.model;

import homelibrary.src.main.java.controller.SaverLoader;
import homelibrary.src.main.java.model.book.Book;

import java.io.IOException;
import java.util.ArrayList;

public class BookContainer {

    private ArrayList<Book> books;

    public BookContainer() {
        this.books = new ArrayList<>();

        try {
            books = SaverLoader.loadCatalog();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public long getNextId() {
        if (books.size() > 0) {
            return books.get(books.size() - 1).getId() + 1;
        } else {
            return 1;
        }

    }

    public boolean checkId(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
