package service;


import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class Mail {

    String smtpServer = "smtp.orange.tn";
    String to ;
    String from = "Serveco@gmail.com";
    String subject = "Serveco TEAM Administration";
    String body;

    public Mail() {
    }

  
    
    public static void send(String smtpServer, String to, String from, String subject, String body) {
        try {
            Properties props = System.getProperties();
            // -- Attaching to default Session, or we could start a new one --
            props.put("mail.smtp.host", smtpServer);
            Session session = Session.getDefaultInstance(props, null);
            // -- Create a new message --
            Message msg = new MimeMessage(session);
            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to, false));
            // -- We could include CC recipients too --
            // if (cc != null)
            // msg.setRecipients(Message.RecipientType.CC
            // ,InternetAddress.parse(cc, false));
            // -- Set the subject and body text --
            msg.setSubject(subject);
            msg.setText(body);
            // -- Set some other header information --
            msg.setHeader("X-Mailer", "LOTONtechEmail");
            msg.setSentDate(new Date());
            // -- Send the message --
            Transport.send(msg);
            
        } catch (Exception ex) {
            //new ExceptionGraphiqueError("Il y'a un problem dans l'envoi de mail verifier votre connextion ou votre address(inter send) ");
            ex.printStackTrace();
        }
    }
}