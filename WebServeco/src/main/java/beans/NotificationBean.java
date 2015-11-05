package beans;

 
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

 


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
 
import javax.faces.context.FacesContext;

import entities.Note;
import entities.Supplier;
import BusinessLogic.NotificationService;
import BusinessLogic.RankJSFLocal;
 


@RequestScoped
@ManagedBean
public class NotificationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	RankJSFLocal rankJSFLocal;

	@EJB
	NotificationService notificationService;


	public RankJSFLocal getRankJSFLocal() {
		return rankJSFLocal;
	}






	public void setRankJSFLocal(RankJSFLocal rankJSFLocal) {
		this.rankJSFLocal = rankJSFLocal;
	}






	public NotificationService getNotificationService() {
		return notificationService;
	}






	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}






	public void sendNotif() {
		Supplier supplier = maxNot().getSupplier();
		

		String text = "Dear Mr " + supplier.getFirstName()
				+ " Congratulation ";
				
		System.out.println(text);

		String subject = "Rank";
		System.out.println(supplier.getMail());
		notificationService.sendMail(subject, text,supplier.getMail(), supplier.getMail());
		
		
		try {
		       FacesContext.getCurrentInstance().getExternalContext()
		            .redirect("Rank.jsf?faces-redirect=true");
		   } catch (IOException ex) {
		       // do something here
		   }
		
	}

	public Note maxNot() {
		List<Note> notes = new ArrayList<Note>();
				notes = rankJSFLocal.findAll();
				int max= 0;
				Note noteMaxi = null;
				for (Note note : notes) {
					if (note.getNoteSup()>max) {
						max = note.getNoteSup();
						noteMaxi = note;
					}
				}
				System.out.println(noteMaxi+"-----note");
				return noteMaxi;
		
	}
	
//	public void test() {
//		Date date = new Date();
//		if ((maxNot().getSupplier()==selectedUser) && (date.getDay()==1)) {
//			sendNotif();
//		}	
//	}

}
