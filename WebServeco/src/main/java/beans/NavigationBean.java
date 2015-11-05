package beans;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
/**
 * Simple navigation bean
 * @author itcuties
 *
 */
@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {
 
    private static final long serialVersionUID = 1520318172495977648L;
 
    /**
     * Redirect to login page.
     * @return Login page name.
     */
    public String redirectToConsult()
    {
    	return "/WebServeco/Pages/supplier/ConsultRes.jsf";
    }
    public String redirectToLogin() {
        return "/login.xhtml?faces-redirect=true";
    }
    public String redirectToSearch() {
        return "/WebServeco/Pages/supplier/S.jsf";
    }   
public String  redirectToClaim() {
    	
    	return "/WebServeco/Pages/supplier/Claim.jsf?faces-redirect=true";
    	
    }
public String  redirectToMap() {
	
	return "/WebServeco/Pages/supplier/coveredArea.jsf?faces-redirect=true";
	
}    
    public String  redirectToNote() {
    	
    	return "/WebServeco/Pages/supplier/Rank.jsf?faces-redirect=true";
    	
    }

    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toLogin() {
        return "/login.xhtml";
    }
     
    /**
     * Redirect to info page.
     * @return Info page name.
     */
    public String redirectToCars() {
        return "/WebServeco/Pages/supplier/cars.jsf";
    }
    public String redirectToRegiser() {
        return "/register.jsf";
    }
    /**
     * Go to info page.
     * @return Info page name.
     */
    public String toNewCarAdd() {
        return "/WebServeco/Pages/supplier/AddCar.jsf";
    }
     
    /**
     * Redirect to welcome page.
     * @return Welcome page name.
     */
    public String redirectToWelcome() {
        return "/WebServeco/Pages/supplier/home.jsf";
    }
     
    /**
     * Go to welcome page.
     * @return Welcome page name.
     */
    public String redirectToEM() {
        return "/WebServeco/Pages/supplier/Mail.jsf";
    }
    public String redirectToON() {
        return "/WebServeco/Pages/supplier/VehiculChange.jsf";
    }
    public String redirectToOFF() {
        return "/WebServeco/Pages/supplier/VehiculStatus.jsf";
    }
}