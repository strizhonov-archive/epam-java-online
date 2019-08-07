package src.main.java.controller;

import src.main.java.Main;
import src.main.java.model.EMail;
import src.main.java.model.person.Person;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EMailSender {

    private Properties props;

    public EMailSender() {
        props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");;
    }

    public void sendEMail(EMail eMail) throws MessagingException {

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(eMail.getFrom(), eMail.getPassword());
                    }
                });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(eMail.getFrom()));
        message.setSubject(eMail.getSubject());

        message.setText(eMail.getMessage());
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(eMail.getTo()));

        Transport.send(message);
    }

    public void notifyAllUsersExceptSender(EMail eMail) throws MessagingException {
        for (Person person : Main.personContainer.getPeople()) {
            String personEMailAddress = person.getEMailAddress();
            if (!eMail.getFrom().equals(personEMailAddress)) {
                eMail.setTo(personEMailAddress);
                sendEMail(eMail);
            }
        }
    }

}
