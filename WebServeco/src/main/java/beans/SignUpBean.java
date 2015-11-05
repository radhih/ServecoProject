package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import BusinessLogic.SupplierJSFLocal;
import entities.Categorie;
import entities.Supplier;


@ManagedBean
@RequestScoped
public class SignUpBean {
	
	
	
	    
	  
	
	   
		private String service;
		private java.util.List<Categorie> services;
	private Supplier supplier=new Supplier();
	private String confirmPasswd;
	 private UploadedFile file;
	 
private String city;
private List<String> cities = new ArrayList<String>();;
	@EJB
	SupplierJSFLocal jsfLocal;


	

	


public String doSignUp()
{ FacesContext context = FacesContext.getCurrentInstance();
FacesMessage message = null;
System.out.println(supplier.getLogin()+""+supplier.getMail() );
	
if(city == null) {
    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error you need you specify your location", "");
}
else if(jsfLocal.checkForLogin(supplier.getLogin())==true)
			{
		
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error try another login", "Login Name Already exist");
		
			}
	
	else if(!( supplier.getPasswd().equals(confirmPasswd)))
	{
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Password error", "Please verify password confirmation");
		
	}
	else{
		supplier.setService(service);
		System.out.println(file);
		System.out.println(file.getFileName());
		supplier.setCoveredArea(city);
		if(city.equals("Sousse"))
		{
			supplier.setLatitude(35.8293446);
			supplier.setLongitude(10.6204533);
		}
		else if(city.equals("Kasserine"))
		{
			supplier.setLatitude(35.1702629);
			supplier.setLongitude(8.824768);
		}
		else 
		{
			supplier.setLatitude(36.4508418);
			supplier.setLongitude(10.7122493);
		}
	supplier.setImage("/Ressources/photos/"+file.getFileName());
	
	jsfLocal.Subscribe(supplier);
		jsfLocal.signup(supplier);
	
	return "/login.jsf";
	}
    context.addMessage(null,message);

	return "";
}
	
	
	public SignUpBean() {
	
		// TODO Auto-generated constructor stub
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}











	public String getConfirmPasswd() {
		return confirmPasswd;
	}

	public void setConfirmPasswd(String confirmPasswd) {
		this.confirmPasswd = confirmPasswd;
	}


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public java.util.List<Categorie> getServices() {
		return jsfLocal.findAllServices();
	}


	public void setServices(java.util.List<Categorie> services) {
		this.services = services;
	}


	 public UploadedFile getFile() {
	        return file;
	    }
	 
	    public void setFile(UploadedFile file) {
	        this.file = file;
	    }


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public List<String> getCities() {
		cities.add("Kasserine");
		cities.add("Sousse");
		cities.add("Nabeul");
			
			return cities;
		}


		public void setCities(List<String> cities) {
			this.cities = cities;
		}

	    
	   
	 
	  
	
}
