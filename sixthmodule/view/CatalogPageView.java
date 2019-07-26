package view;

import controller.Main;
import model.book.Book;

import java.util.ArrayList;

public class CatalogPageView {

    private static final int LINES = 30;
    private static int currentLines;
    private static int currentBook;
    private ArrayList<Book> books;

    public CatalogPageView() {
        books = Main.bookContainer.getBooks();
        currentBook = 0;
    }

    public boolean view(boolean fromStart) {
        if (fromStart) {
            currentBook = 0;
        }

        for (int i = currentBook; i < books.size(); i++) {
            System.out.println(books.get(i));
            currentLines += books.get(i).getLines();
            currentBook = i + 1;
            if (i == books.size() - 1) {
                return true;
            }
            if (currentLines > LINES) {
                currentLines = 0;
                return false;
            }
        }
        return true;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
