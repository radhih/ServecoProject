package TModel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import BusinessLogic.ISbuscriptionSupplier;
import BusinessLogic.RemoteSubscription;
import entities.SubscriptionAdmin;
import entities.SubscriptionSupplier;

public class SubsSuppliersT extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8897197684471267766L;
	String [] columTab = {"id","description","login","name","status","Vehicule","supplier"};	
	List<SubscriptionSupplier> Subsups =new ArrayList<SubscriptionSupplier>();
	ISbuscriptionSupplier c=null;
	 public SubsSuppliersT(String service) {
		// TODO Auto-generated constructor stub
	 String status="NotValidated";
			Context ctx;
		try {
			ctx = new InitialContext();
			c =  (ISbuscriptionSupplier) ctx.lookup("/WebServeco/SubscriptionSupplierCrud!BusinessLogic.ISbuscriptionSupplier");
		Subsups=c.findinscptionsuppbyserviceandstatus(service,status);
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public int getRowCount() {
	
		return Subsups.size();
	}

	@Override
	public int getColumnCount() {
		
		return columTab.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	
		
		switch (columnIndex){
        case 0:
            return Subsups.get(rowIndex).getId();
        case 1:
        	 return Subsups.get(rowIndex).getDescription();
        case 2:
       	 return Subsups.get(rowIndex).getLogin();
        case 3:
       	 return Subsups.get(rowIndex).getName();
        case 4:
       	 return Subsups.get(rowIndex).getStatus();
        case 5:
          	 return Subsups.get(rowIndex).getTypevehicul();
       
        case 6:
         	 return Subsups.get(rowIndex).getSupplier().getFirstName();    	 
           
           
          	 
        
        default:
              return null;
		}
	}

	 public String getColumnName(int column) {
	       return  columTab[column];
	    }

      public void deleteRow(int rowIndex) {
        
        Subsups.remove(rowIndex);
        
    fireTableDataChanged();
   }


}
