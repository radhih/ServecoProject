package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;





import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import BusinessLogic.SupplierJSFLocal;
import entities.Categorie;
import entities.Vehicul;

@ManagedBean
@RequestScoped
public class CarBean implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6866273435802212334L;
	private String brand;
	
	public CarBean() {
		super();
		// TODO Auto-generated constructor stub
	}



	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	 private UploadedFile file;
	    private boolean value1;  

	@EJB
	SupplierJSFLocal sJsfLocal;
	
	
	
	public String DoAddCar()
	{FacesContext context = FacesContext.getCurrentInstance();
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "YOur Car Has been Added");;
		 Vehicul car=new Vehicul();
		if(value1)
		{
			car.setAvailable("available");
		}else{
			car.setAvailable("NoAvailable");
		}
		 
		 car.setAvailable("available");
		car.setType(brand);
			car.setNomsupplier(userBean.getSupplier().getFirstName());

			//car.setAvailable("NotAvailable");
			car.setImage(file.getFileName());
			Categorie c=sJsfLocal.findServiceByName(userBean.getSupplier().getService());
			car.setCategories(c);
			
			sJsfLocal.addCar(car);
			  
    
	
   context.addMessage(null,message);
			return "";
	
		
	}





	public LoginBean getUserBean() {
		return userBean;
	}



	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}



	public UploadedFile getFile() {
		return file;
	}



	public void setFile(UploadedFile file) {
		this.file = file;
	}



	public boolean isValue1() {
		return value1;
	}



	public void setValue1(boolean value1) {
		this.value1 = value1;
	}





	public String getBrand() {
		return brand;
	}





	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
