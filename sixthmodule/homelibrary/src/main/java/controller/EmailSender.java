package homelibrary.src.main.java.controller;

import homelibrary.src.main.java.Main;
import homelibrary.src.main.java.model.Email;
import homelibrary.src.main.java.model.person.Person;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    private Properties props;

    public EmailSender() {
        props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    public void sendEmail(Email email) throws MessagingException {

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email.getFrom(), email.getPassword());
                    }
                });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email.getFrom()));
        message.setSubject(email.getSubject());

        message.setText(email.getMessage());
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));

        Transport.send(message);
    }

    public void notifyAllUsersExceptSender(Email email) throws MessagingException {
        for (Person person : Main.personContainer.getPeople()) {
            String personEMailAddress = person.getEMailAddress();
            if (!email.getFrom().equals(personEMailAddress)) {
                email.setTo(personEMailAddress);
                sendEmail(email);
            }
        }
    }

}
