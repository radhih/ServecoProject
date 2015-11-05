package beans; 
import java.io.Serializable;

import javax.ejb.EJB;

import org.primefaces.model.ScheduleModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;

import entities.Reservation;
import BusinessLogic.ReservationJSFLocal;

@ManagedBean
@ViewScoped
public class ScheduleView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScheduleModel eventModel;
    @ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;	
	@EJB
	ReservationJSFLocal reser;

    public LoginBean getUserBean() {
		return userBean;
	}
	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}
	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	@PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        List<Reservation> reservations=reser.findreservbySupplierName(userBean.getSupplier().getFirstName());
       for(Reservation r:reservations)
       {
        eventModel.addEvent(new DefaultScheduleEvent("Reservation of" + r.getVehicul().getType(), StringtoDate(r.getDate()), StringtoDate(r.getDate())));
       }
      
    }
    public ScheduleModel getEventModel() {
        return eventModel;
 }
  
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public Date StringtoDate(String dateString)
    {
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    	String dateInString = dateString;
    	Date date = null ;
    	try {    
    		date = formatter.parse(dateInString);    
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
		return date;
    	
    }
}