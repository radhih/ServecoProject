package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entities.Supplier;
import entities.SupplierClaim;
import BusinessLogic.SupplierClaimJSFLocal;
 

@ManagedBean
@SessionScoped
public class AddSupClaimBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB SupplierClaimJSFLocal s;
	
	
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	
	
	SupplierClaim sclaim = new SupplierClaim() ;
	
	
	public SupplierClaim getSclaim() {
		return sclaim;
	}

	public void setSclaim(SupplierClaim sclaim) {
		this.sclaim = sclaim;
	}



	public String DoAdd(){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		
		sclaim.setSup(userBean.getSupplier());
		s.AddClaim(sclaim);
		
	    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "YOUR CLAIM HAS BEEN SENT", "");
	       context.addMessage(null,message);

		return "";
	}

	public LoginBean getUserBean() {
		return userBean;
	}

	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}
	
	
	
	
	
}
