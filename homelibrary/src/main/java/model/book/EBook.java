package src.main.java.model.book;

public class EBook extends Book {

    public EBook(String name, String author, long id) {
        super(name, author, id);
    }

    public EBook(String name, String author, long id, String description) {
        super(name, author, id, description);
    }
}
