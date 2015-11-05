package TModel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import BusinessLogic.RemoteVehicul;

import entities.Vehicul;

public class VehiculT extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String [] columTab = {"id","type","nomsupplier","service"};	
	List<Vehicul> vehiclus =new ArrayList<Vehicul>();
	RemoteVehicul c=null;
	public VehiculT() {
		Context ctx;
	try {
		ctx = new InitialContext();
		c =  (RemoteVehicul) ctx.lookup("/WebServeco/VehiculCrud!BusinessLogic.RemoteVehicul");
		vehiclus=c.afficher();
	
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return vehiclus.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columTab.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex){
        case 0:
            return vehiclus.get(rowIndex).getId();
        case 1:
        	 return vehiclus.get(rowIndex).getType();
        case 2:
       	 return vehiclus.get(rowIndex).getNomsupplier();
        case 3:
       	 return vehiclus.get(rowIndex).getCategories().getName();    
        
        default:
              return null;
}

	}
	
	 public String getColumnName(int column) {
	       return  columTab[column];
	    }

	public void addRow(Vehicul a) {
      vehiclus.add(a);
    // fireTableRowsInserted(getRowCount() -1, getRowCount() -1);
    fireTableDataChanged();
     }
	
       public void deleteRow(int rowIndex) {
         
          vehiclus.remove(rowIndex);
         
     fireTableDataChanged();
    }
	}


