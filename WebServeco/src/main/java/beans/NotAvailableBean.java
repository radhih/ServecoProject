package beans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import BusinessLogic.SupplierJSFLocal;
import entities.Vehicul;

@ManagedBean
@SessionScoped
public class NotAvailableBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	
	private Vehicul care;
	private List<Vehicul> carse;
	
	@EJB
	SupplierJSFLocal sJsfLocal;
	public NotAvailableBean() {
	
	}	
	
	
	
	
	public String doTurnOnV()
	{
System.out.println("mmmmmmm:"+care.getAvailable());
	care.setAvailable("Available");
		sJsfLocal.turnOnCar(care);	
		return "";
		
	}	
	public Vehicul getCare() {
		return care;
	}

	
	public void setCare(Vehicul care) {
		this.care = care;
	}

	
	public List<Vehicul> getCarse() {
		return sJsfLocal.getMyCarse(userBean.getSupplier().getFirstName());
	}

	
	public void setCarse(List<Vehicul> carse) {
		this.carse = carse;
	}

	
	
	public LoginBean getUserBean() {
		return userBean;
	}

	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}
	

}

