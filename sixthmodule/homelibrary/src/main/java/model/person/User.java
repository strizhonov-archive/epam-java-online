package homelibrary.src.main.java.model.person;

import homelibrary.src.main.java.controller.EmailSender;
import homelibrary.src.main.java.model.Email;
import homelibrary.src.main.java.model.PersonContainer;
import homelibrary.src.main.java.model.book.BookTemplate;

import javax.mail.MessagingException;
import java.util.ArrayList;

public class User extends Person {

    public User(String login, String password, String eMailAddress) {
        super(login, password, eMailAddress);
    }

    public void suggest(BookTemplate bookTemplate, String password) throws MessagingException {
        PersonContainer personContainer = new PersonContainer();
        ArrayList<Person> people = personContainer.getPeople();

        EmailSender ems = new EmailSender();

        String text = "I want to suggest new book to the catalog." +
                "\nName: " +
                bookTemplate.getName() +
                "\nAuthor: " +
                bookTemplate.getAuthor();

        Email eMail = Email.EmailBuilder.getInstance()
                .from(this.getEMailAddress())
                .password(password)
                .subject("New book suggestion.")
                .message(text)
                .build();

        for (Person person : people) {
            if (person instanceof Admin) {
                String sendTo = person.getEMailAddress();
                eMail.setTo(sendTo);
                ems.sendEmail(eMail);
            }
        }

    }
}

