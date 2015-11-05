package BusinessLogic;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.transform.Source;


@Stateless
public class NotificationServiceImpl implements NotificationService{

	String SMTP_HOST1 = "smtp.gmail.com";
	String LOGIN_SMTP1 = "starsuppp";
	String IMAP_ACCOUNT1 = "starsuppp@gmail.com";
	String PASSWORD_SMTP1 = "starsupstarsup";
	Transport transport = null;
	
	@Override
	public boolean sendMail(String subject, String text, String destinataire, String copyDest) {
		// TODO Auto-generated method stub
	    // 1 -> Création de la session 
		Date dateSend=new Date();
	    Properties properties = new Properties(); 
	    properties.setProperty("mail.transport.protocol", "smtp"); 
	    properties.setProperty("mail.smtp.host", SMTP_HOST1); 
	    properties.setProperty("mail.smtp.user", LOGIN_SMTP1); 
	    properties.setProperty("mail.from", IMAP_ACCOUNT1); 
	    properties.setProperty("mail.smtp.starttls.enable", "true");
	    Session session = Session.getInstance(properties); 
		
		
	    // 2 -> Création du message 
	    MimeMessage message = new MimeMessage(session); 
	    try { 
	        message.setText(text); 
	        message.setSubject(subject); 
	        message.addRecipients(Message.RecipientType.TO, destinataire); 
	        message.addRecipients(Message.RecipientType.CC, copyDest); 
	    } catch (MessagingException e) { 
	        e.printStackTrace(); 
	    } 	    
	
	
    // 3 -> Envoi du message 
    try { 
    	
    	System.out.println(dateSend.getDate());
    	if(dateSend.getDay()==1)
        {
    	Transport transport = session.getTransport("smtp"); 
        transport.connect(LOGIN_SMTP1, PASSWORD_SMTP1);
       
        transport.sendMessage(message, new Address[] { new InternetAddress(destinataire),new InternetAddress(copyDest) }); 
       }
       } catch (MessagingException e) { 
        e.printStackTrace(); 
    } finally { 
        try { 
            if (transport != null) { 
                transport.close(); 

            } 

        } catch (MessagingException e) { 

            e.printStackTrace(); 
        } 
    }
	return true; 
}
	

}
