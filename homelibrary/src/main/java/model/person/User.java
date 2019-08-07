package model.person;

import controller.EMailSender;
import model.EMail;
import model.PersonContainer;
import model.book.BookTemplate;

import javax.mail.MessagingException;
import java.util.ArrayList;

public class User extends Person {

    public User(String login, String password, String eMailAddress) {
        super(login, password, eMailAddress);
    }

    public void suggest(BookTemplate bookTemplate, String password) throws MessagingException {
        PersonContainer personContainer = new PersonContainer();
        ArrayList<Person> people = personContainer.getPeople();

        EMailSender ems = new EMailSender();

        String text = "I want to suggest new book to the catalog." +
                "\nName: " +
                bookTemplate.getName() +
                "\nAuthor: " +
                bookTemplate.getAuthor();

        EMail eMail = EMail.EMailBuilder.getInstance()
                .from(this.getEMailAddress())
                .password(password)
                .subject("New book suggestion.")
                .message(text)
                .build();

        for (Person person : people) {
            if (person instanceof Admin) {
                String sendTo = person.getEMailAddress();
                eMail.setTo(sendTo);
                ems.sendEMail(eMail);
            }
        }

    }
}

