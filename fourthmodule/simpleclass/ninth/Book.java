package simpleclass.ninth;

import java.util.Arrays;

public class Book {

    private long id;
    private String name;
    private String[] authors;
    private String publisher;
    private int publicationYear;
    private int pages;
    private double price;
    private boolean isCoverHard;

    public Book(long id, String name, String[] authors, String publisher,
                int publicationYear, int pages, double price, boolean isCoverHard) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.price = price;
        this.isCoverHard = isCoverHard;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCoverHard() {
        return isCoverHard;
    }

    public void setCoverHard(boolean coverHard) {
        isCoverHard = coverHard;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", publisher='" + publisher + '\'' +
                ", publicationYear=" + publicationYear +
                ", pages=" + pages +
                ", price=" + price +
                ", isCoverHard=" + isCoverHard +
                '}';
    }
}
