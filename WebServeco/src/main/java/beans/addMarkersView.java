package beans;
import java.io.Serializable;

import javax.annotation.PostConstruct; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
  

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
 
@ManagedBean
public class addMarkersView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{loginBean}")
	private LoginBean userBean;
	
	private MapModel emptyModel;
      
    private String title;
      
    private double lat;
      
    private double lng;
  
    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
      
        
    }
      
    public MapModel getEmptyModel() {
    	 Marker marker = new Marker(new LatLng(userBean.getSupplier().getLatitude(),userBean.getSupplier().getLongitude()), title);
         emptyModel.addOverlay(marker);
    	return emptyModel;
    }
      
    public String getTitle() {
        return userBean.getSupplier().getCoveredArea();
    }
  
    public void setTitle(String title) {
        this.title = title;
    }
  
    public double getLat() {
        return userBean.getSupplier().getLatitude();
    }
  
    public void setLat(double lat) {
        this.lat = lat;
    }
  
    public double getLng() {
        return userBean.getSupplier().getLongitude();
    }
  
    public void setLng(double lng) {
        this.lng = lng;
    }

	public LoginBean getUserBean() {
		return userBean;
	}

	public void setUserBean(LoginBean userBean) {
		this.userBean = userBean;
	}
      
  
}