package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

import entities.Admin;
import entities.Reservation;
import entities.Supplier;
import entities.Vehicul;
import BusinessLogic.RemoteReserv;
import BusinessLogic.RemoteSupplier;
import BusinessLogic.RemoteVehicul;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UIhandle extends JFrame {

	private JPanel contentPane;
	private JOptionPane jOptionPane1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIhandle frame = new UIhandle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
 public void Actionback(java.awt.event.ActionEvent e)
	{
		this.setVisible(false);
	}
	
	
	public UIhandle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnSelectSupplier = new JButton("Select Supplier");
		btnSelectSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelectSupplier.setBounds(46, 202, 131, 39);
		contentPane.add(btnSelectSupplier);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(62, 92, 89, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(315, 92, 107, 20);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(311, 202, 121, 39);
		contentPane.add(btnNewButton);
	}
	
	public UIhandle(final int id,Admin a)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		contentPane.add(btnBack);	
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Actionback(e);
			}
		});
		
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(62, 92, 89, 20);
		RemoteSupplier sc;
		Context ctx;
        List<Supplier> suppliers=new ArrayList<Supplier>();
        try {
			ctx = new InitialContext();
			sc = (RemoteSupplier) ctx.lookup("/WebServeco/SupplierCrud!BusinessLogic.RemoteSupplier");	
		     suppliers=sc.afficher(a.getService());
		     for (Supplier so:suppliers) {
					
		           comboBox.addItem(so.getFirstName());
		      //     System.out.println(so.getName());
		       }
        } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		contentPane.add(comboBox);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(315, 92, 107, 20);
		RemoteVehicul v;
		Context ctx2;
        List<Vehicul> vs=new ArrayList<Vehicul>();
        try {
			ctx = new InitialContext();
			v =  (RemoteVehicul) ctx.lookup("/WebServeco/VehiculCrud!BusinessLogic.RemoteVehicul");	
		    vs=v.afficherSupVehiculs(comboBox.getSelectedItem().toString());
			
			
		     for (Vehicul so:vs) {
					
		           comboBox_1.addItem(so.getId());
		      //     System.out.println(so.getName());
		       }
        } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		contentPane.add(comboBox_1);
		
		final JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Context ctx;
				RemoteReserv c;
				Reservation r=new Reservation();
				try {				
						ctx = new InitialContext();
						c =  (RemoteReserv) ctx.lookup("/WebServeco/ReservCrud!BusinessLogic.RemoteReserv");
r=c.findById(id);				
					} 
				catch (NamingException e1)
				{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			System.out.println(r.getId());
			Context ctx2;
			Vehicul vehicul =new Vehicul();
		RemoteVehicul remv;	
		try {				
			ctx2 = new InitialContext();
			remv =   (RemoteVehicul) ctx2.lookup("/WebServeco/VehiculCrud!BusinessLogic.RemoteVehicul");
			
			vehicul=remv.findById((int) comboBox_1.getSelectedItem());
		} 
	catch (NamingException e1)
	{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		r.setNamesupplier(comboBox.getSelectedItem().toString());
		System.out.println(vehicul.getId());
		//r.setVehicul(null);
		r.setVehicul(vehicul);
		RemoteReserv remoteR;
		Context ctx3;
		try {				
			ctx3 = new InitialContext();
			remoteR = (RemoteReserv) ctx3.lookup("/WebServeco/ReservCrud!BusinessLogic.RemoteReserv");
			remoteR.update(r);
            jOptionPane1.showMessageDialog(null,"Accident was handled with success");			
		} 
	catch (NamingException e1)
	{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
			
			
			
			}
		});
		comboBox_1.setVisible(false);
		btnNewButton.setVisible(false);
		btnNewButton.setBounds(311, 202, 121, 39);
		contentPane.add(btnNewButton);
	
		JButton btnSelectSupplier = new JButton("Select Supplier");

		btnSelectSupplier.setBounds(46, 202, 131, 39);
		contentPane.add(btnSelectSupplier);
		
		btnSelectSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			comboBox_1.setVisible(true);
			btnNewButton.setVisible(true);
			
			
			}
		});
	
	}
}
