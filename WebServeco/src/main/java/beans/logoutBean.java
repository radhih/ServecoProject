package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class logoutBean {

	
	
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	
	
	public String logout()
	{
	
    //  FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "/WebServeco/login.jsf?faces-redirect=true";
}


	public logoutBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoginBean getUserBean() {
		return userBean;
	}


	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}
	
	
}
