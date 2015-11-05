package TModel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import BusinessLogic.RemoteService;
import BusinessLogic.RemoteSupplier;
import entities.Categorie;
import entities.Supplier;

public class SupplierT extends AbstractTableModel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1408413659647510087L;

String [] columTab = {"id","firstName","lastName","login","mail","CoveredArea","phoneNumber","Vehiculs","service"};
	
	List<Supplier> suppliers =new ArrayList<Supplier>();
	RemoteSupplier c;
	
	public SupplierT(String service)
	{
		Context ctx;
		try {
			ctx = new InitialContext();
			c = (RemoteSupplier) ctx.lookup("/WebServeco/SupplierCrud!BusinessLogic.RemoteSupplier");
		suppliers=c.afficher(service);
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public int getRowCount() {
		return suppliers.size();
	
	}

	@Override
	public int getColumnCount() {
		return columTab.length;
	
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex){
        case 0:
            return suppliers.get(rowIndex).getId();
 
        case 1:
            return suppliers.get(rowIndex).getAge();
        case 2:
            return suppliers.get(rowIndex).getFirstName();
        case 3:
            return suppliers.get(rowIndex).getLastName();
        case 4:
            return suppliers.get(rowIndex).getLogin();
        case 5:
            return suppliers.get(rowIndex).getMail();
        case 6:
            return suppliers.get(rowIndex).getCoveredArea();
        case 7:
            return suppliers.get(rowIndex).getPhoneNumbe();
        case 8:
            return suppliers.get(rowIndex).getNbvehicul();
        case 9:
            return suppliers.get(rowIndex).getService();
        default:
              return null;
}
	}
	 public String getColumnName(int column) {
	       return  columTab[column];
	    }


}
