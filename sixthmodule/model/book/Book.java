package model.book;

import controller.EMailSender;
import model.EMail;
import model.person.Person;

import javax.mail.MessagingException;

public class Book extends BookTemplate {

    private long id;
    private String description;
    private int lines;

    public Book(String name, String author, long id) {
        super(name, author);
        this.id = id;
        lines = 5; //id name author type divider
    }

    public Book(String name, String author, long id, String description) {
        super(name, author);
        this.id = id;
        this.description = description;
        lines = 5 + getDescriptionLines(description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description, Person person, String eMailPass) throws MessagingException {
        this.description = description;

        lines += 1;
        lines += getDescriptionLines(description);

        EMailSender ems = new EMailSender();

        String text = "The book "
                + this.getName()
                + " of "
                + this.getAuthor()
                + " got new description: \n"
                + description;

        EMail eMailWithoutTo = EMail.EMailBuilder.getInstance()
                .from(person.getEMailAddress())
                .password(eMailPass)
                .subject("New description.")
                .message(text)
                .build();

        ems.notifyAllUsersExceptSender(eMailWithoutTo);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    private int getDescriptionLines(String description) {
        int lines = 0;
        for (int i = 0; i < description.length(); i++) {
            if (description.charAt(i) == 10
                    || description.charAt(i) == 13) {
                lines += 1;
            }
        }
        return lines;
    }

    @Override
    public String toString() {
        String name =  "Book:" +
                "\nid=" + id +
                "\nname=" + getName() +
                "\nauthor=" + getAuthor() +
                "\ntype=" + this.getClass().getSimpleName() +
                "\n";

        if (description != null) {
             name += "description=\n" + description +
                     "\n";
        }
        return name ;
    }

    public static class BookFactory {
        public static Book getBook(boolean isPaper,
                                   String name,
                                   String author,
                                   long id) {
            return isPaper ? new PaperBook(name, author, id) : new EBook(name, author, id);
        }

        public static Book getBook(boolean isPaper,
                                   String name,
                                   String author,
                                   long id,
                                   String description) {
            return isPaper
                    ? new PaperBook(name, author, id, description)
                    : new EBook(name, author, id, description);
        }
    }

}
