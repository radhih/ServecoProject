package BusinessLogic;

import javax.ejb.Local;
 
@Local
public interface NotificationService {

	boolean sendMail(String subject, String text, String destinataire, String copyDest);
}
