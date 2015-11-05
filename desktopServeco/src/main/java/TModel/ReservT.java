package TModel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import BusinessLogic.RemoteReserv;
import entities.Reservation;

public class ReservT extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5099730110348692509L;
	public String [] columTab = {"id","date","supplier","Accepted","client","vehicul"};	
	List<Reservation> res =new ArrayList<Reservation>();
	RemoteReserv c=null;
	public ReservT() {
			Context ctx;
		try {
			ctx = new InitialContext();
			c =   (RemoteReserv) ctx.lookup("/WebServeco/ReservCrud!BusinessLogic.RemoteReserv");
		res=c.findreserv();
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return res.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columTab.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex){
        case 0:
            return res.get(rowIndex).getId();
        case 1:
            return res.get(rowIndex).getDate();
        case 2:
            return res.get(rowIndex).getNamesupplier();
        case 3:
            return res.get(rowIndex).isStatus();
        case 4:
            return res.get(rowIndex).getClient().getFirstName();
        case 5:
            return res.get(rowIndex).getVehicul().getType(); 
        default:
              return null;
		}
	}
	 public String getColumnName(int column) {
	       return  columTab[column];
	    }

    public void deleteRow(int rowIndex) {
      
      res.remove(rowIndex);
      
  fireTableDataChanged();
 }

}
