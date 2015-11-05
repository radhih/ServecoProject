package TModel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import BusinessLogic.RemoteAdvertisement;
import entities.Advertisement;

public class AdvertisementT extends AbstractTableModel{

	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2388674823714912587L;
	public String [] columTab = {"id","Topic","SupName"};	
	List<Advertisement> advertisements =new ArrayList<Advertisement>();
	RemoteAdvertisement c=null;

	public AdvertisementT() {
		Context ctx;

		try {
			ctx = new InitialContext();
			c =  (RemoteAdvertisement) ctx.lookup("/WebServeco/AdvertisementCrud!BusinessLogic.RemoteAdvertisement");
			advertisements= c.affiche() ;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	
}
	
	@Override
	public int getRowCount() {
		return advertisements.size();
	}

	@Override
	public int getColumnCount() {
		return columTab.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex){
        case 0:
            return advertisements.get(rowIndex).getId();
        case 1:
        	 return advertisements.get(rowIndex).getTopic();
        case 3:
        	 return advertisements.get(rowIndex).getSup().getFirstName();
default:
              return null;
}
	}
	public String getColumnName(int column) {
	       return  columTab[column];
	    }
	
	public void deleteRow(int rowIndex) {
        
		advertisements.remove(rowIndex);
       
   fireTableDataChanged();
  }
	
	public void addRow(Advertisement a) {
		advertisements.add(a);
     fireTableRowsInserted(getRowCount() -1, getRowCount() -1);
    //fireTableDataChanged();
     }

}
