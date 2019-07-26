package model.book;

public class PaperBook extends Book {

    public PaperBook(String name, String author, long id) {
        super(name, author, id);
    }

    public PaperBook(String name, String author, long id, String description) {
        super(name, author, id, description);
    }
}
