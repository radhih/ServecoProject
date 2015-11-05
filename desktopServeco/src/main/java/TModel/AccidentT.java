package TModel;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import BusinessLogic.RemoteAccident;
import BusinessLogic.RemoteAdmin;
import BusinessLogic.RemoteClaim;
import entities.Accident;
import entities.Admin;
import entities.Claim;

public class AccidentT extends AbstractTableModel{
	public String [] columTab = {"id","Topic","reservation","service"};	
	List<Accident> as =new ArrayList<Accident>();
	
	RemoteAccident c=null;
	public AccidentT(Admin a) {
		Context ctx;

		try {
			ctx = new InitialContext();
			c =  (RemoteAccident) ctx.lookup("/WebServeco/AccidentCrud!BusinessLogic.RemoteAccident");
		
		as=c.getAllAccident(a.getService());
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	
}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return as.size();
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
            return as.get(rowIndex).getId();
        case 1:
        	 return	as.get(rowIndex).getTopic();
        case 2:
        	 return as.get(rowIndex).getReservation().getId();
        case 3:
        	 return as.get(rowIndex).getService();
default:
              return null;
}
	}
	 public String getColumnName(int column) {
	       return  columTab[column];
	    }

}
