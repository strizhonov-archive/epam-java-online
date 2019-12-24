package simpleclass.ninth;

/**
 * Testing class
 */
public class Main {

    public static void main(String[] args) {

        Book[] books = new Book[]{
                new Book(1, "Idiot", new String[]{"Dostoevskiy"}, "Astrel",
                        1954, 259, 843, true),
                new Book(12, "Revisor", new String[]{"Gogol"}, "IZDAT",
                        1966, 166, 456, true),
                new Book(44, "The Twelve Chairs", new String[]{"Ilf", "Petrov"}, "IZDAT",
                        1949, 99, 564, false),
                new Book(11, "Unknown Story", new String[]{"Petrov"}, "EKSMO",
                        1999, 14, 143, false)
        };

        BookList bList = new BookList(books);

        bList.printAuthorBooks("Petrov");
        bList.printBooksAfterYear(1950);
        bList.printPublisherBooks("IZDAT");

    }

}
