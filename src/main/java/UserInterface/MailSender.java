package UserInterface;

import Utilities.MyLogger;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailSender {
    public static void send(String subject, String problem) {
        final Logger LOGGER = MyLogger.LOGGER;

        final String username = "witalikspelina@gmail.com";
        final String password = "rirm ckpz vdxy ascx";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("witalikspelina@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("witalikspelina@gmail.com")
            );
            message.setSubject(subject);
            message.setText(problem);

            Transport.send(message);
            LOGGER.log(Level.INFO, "Відправлено Е-майл на адресу witalikspelina@gmail.com");

        } catch (MessagingException e) {
            LOGGER.log(Level.WARNING, "Помилка у відправці Е-майлу, witalikspelina@gmail.com", e);
        }
    }

}