package beans;



import java.util.Date;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

@ManagedBean(name = "mailingBean")
@ViewScoped
public class Mail {
	private String subject;
	private String corp;
	private Date date;

	
	@ManagedProperty(value = "#{reservationBean}")
	private ReservationBean reservationBean;
	
	private String to;

	
	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Mail() {
	}

	public Mail(String to, String subject, String corp, Date date) {
		this.to = to;
		this.subject = subject;
		this.corp = corp;
		this.date = date;
	}

	public String send() {
		System.out.println("bonjour....");
		to=reservationBean.getSelectRes().getClient().getMail();
System.out.println("TO..."+to);
		try {
			System.out.println("bonjour....");
			System.out.println(to);
			String username = "serveco.esprit@gmail.com";
			String password = "radhihouli";
			String recipient = to;
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.from", "serveco.esprit@gmail.com");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.setProperty("mail.debug", "true");
			Session session = Session.getInstance(props, null);
			MimeMessage msg = new MimeMessage(session);
			msg.setRecipients(Message.RecipientType.TO, recipient);
			System.out.println("sqsqqqqqqqqqqq"+recipient);
			msg.setSubject(subject);

			System.out.println(subject);

			msg.setSentDate(new Date());
			msg.setText(corp);

			System.out.println(corp);

			Transport transport = session.getTransport("smtp");
			transport.connect(username, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (MessagingException me) {
			me.printStackTrace();
		}

	return "";
	}

	public ReservationBean getReservationBean() {
		return reservationBean;
	}

	public void setReservationBean(ReservationBean reservationBean) {
		this.reservationBean = reservationBean;
	}


}
