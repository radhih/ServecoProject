package beans;

import javax.annotation.PostConstruct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
 

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;

import entities.Supplier;
import BusinessLogic.Localsupplier;
 
@ManagedBean

public class ChartView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1091893673712928617L;

	@EJB
	    private Localsupplier localSupplier ;
 
    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() {
    	List<Supplier> suppliers = new ArrayList<Supplier>();
    	suppliers=localSupplier.afficherSup();
    	
        BarChartModel model = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Suppliers");
        for (Supplier supplier : suppliers) {
        	System.out.println(supplier.getFirstName()+"----"+localSupplier.affMoyNotes(supplier.getId()));
        	boys.set(supplier.getFirstName(), localSupplier.affMoyNotes(supplier.getId()));
		}
       
 
      
 
        model.addSeries(boys);
     
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
       
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Statistic Dashbord");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Suppliers");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Notes");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
     
    





}
