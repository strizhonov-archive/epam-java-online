package simpleclass.ninth;

public class BookList {

    private Book[] books;

    public BookList(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public void printAuthorBooks(String author) {
        System.out.println("The books, written by " + author + ":");

        for (Book book : books) {
            for (String oneOfAuthors : book.getAuthors()) {
                if (oneOfAuthors.equals(author)) {
                    System.out.println(book);
                }
            }
        }
    }

    public void printPublisherBooks(String publisher) {
        System.out.println("The books, published by " + publisher + ":");

        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                System.out.println(book);
            }
        }
    }

    public void printBooksAfterYear(int minYear) {
        System.out.println("The books, published after " + minYear + ":");

        for (Book book : books) {
            if (book.getPublicationYear() > minYear) {
                System.out.println(book);
            }
        }
    }

}
