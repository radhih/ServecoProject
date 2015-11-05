
package beans;


import java.io.IOException;
import java.io.Serializable;





import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;







import BusinessLogic.SupplierJSFLocal;
import entities.Supplier;
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6627142125408267885L;

	
	private Boolean loggedSupplier=false;


	private Supplier supplier=new Supplier();
private boolean activatedAccount=false;
	
	@EJB
	SupplierJSFLocal s;
	
	public LoginBean() {
		
	}
	
	public String doLogin() 
	{         FacesContext context = FacesContext.getCurrentInstance();
	FacesMessage message = null;

		Supplier user = s.auth(supplier.getPasswd(),supplier.getLogin());
		if(user != null)
		{		
			activatedAccount=s.checkForActivation(user);
if(activatedAccount==false)
{
    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "YOUR ACCOUNT IS NOT ACTIVATED YET", "Please check your E-Mail");
	
}else{
			//JSFUtils.setLoggedinUser(user);
	
	
		supplier = user;
			loggedSupplier=true;
			System.out.println(""+loggedSupplier);
	      //  context.addMessage(null, new FacesMessage("Successful",  "Your message: " +"") );
			return "/Pages/supplier/home?faces-redirect=true";
}	
		}else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Logging Error", "Invalid credentials");
        }
		
       context.addMessage(null,message);
		
		return "";
	}
	
	

	public String logout()
	{
		//loggedSupplier=false;
      FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/WebServeco/login.jsf?faces-redirect=true";
}
	 // ------------------------------
    // Getters & Setters 
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	 public boolean isLoggedIn() {
	        return loggedSupplier;
	    }
	 
	    public void setLoggedIn(boolean loggedIn) {
	        this.loggedSupplier = loggedIn;
	    }

		public boolean isActivatedAccount() {
			return activatedAccount;
		}

		public void setActivatedAccount(boolean activatedAccount) {
			this.activatedAccount = activatedAccount;
		}

		  public String redirectToRegiser() {
		        return "/WebServeco/register.jsf";
		    }
	
	
	
}