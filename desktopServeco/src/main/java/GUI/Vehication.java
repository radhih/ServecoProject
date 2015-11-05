package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TabExpander;

import BusinessLogic.RemoteService;
import BusinessLogic.RemoteSupplier;
import BusinessLogic.RemoteVehicul;
import TModel.ServiceT;
import TModel.SupplierT;
import TModel.VehiculT;
import entities.Categorie;
import entities.Supplier;
import entities.Vehicul;

import javax.swing.JComboBox;

public class Vehication extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4304732471058599857L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JFileChooser jFileChooser1;
	private JTextField textField_1;


	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vehication frame = new Vehication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	private void upload(java.awt.event.ActionEvent evt)
	{
		JFileChooser chooser=new JFileChooser();
	    jFileChooser1.showOpenDialog(null);
	     File f=jFileChooser1.getSelectedFile();
	     String filename=f.getName();
	     textField_1.setText(filename);
	}
	public void  btnSActionPerformed(java.awt.event.ActionEvent e)
	{
		this.setVisible(false);
	 new Vehication().setVisible(true);
		
	}
	//public void btnNewtActionPerformed(java.awt.event.ActionEvent e)
	//{
	//this.setVisible(false);
	//new SubscriptionManagment().setVisible(true);
	//}
	//public void BtnManagmentActionPerformed(java.awt.event.ActionEvent e)
	//{
		//this.setVisible(false);
		//new MangmentAdmins().setVisible(true);
	//}
	//public void btnHomActionPerformed(java.awt.event.ActionEvent e)
	 //{	this.setVisible(false);
		// new SuperM().setVisible(true);
	 //}
	public void btnLogOutActionPerformed(java.awt.event.ActionEvent e)
	 {
		 this.setVisible(false);
		 //new Authentification().setVisible(true);
	 }

	/**
	 * Create the frame.
	 */
	public Vehication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 432);
		jFileChooser1 = new JFileChooser();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new VehiculT());
		JButton btnHome = new JButton("Home");
		
		JButton btnLogOut = new JButton("Go back");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnLogOutActionPerformed(e);
			}
		});
		btnLogOut.setBounds(595, 11, 112, 43);
		contentPane.add(btnLogOut);
		
		JButton btnServiceManagment = new JButton("Vehication");
		btnServiceManagment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnSActionPerformed(e);
			}
		});
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(302, 350, 175, 26);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
		        VehiculT ct=(VehiculT) table_1.getModel();
				Vehicul c=new Vehicul();
				
				Context ctx2;
				RemoteVehicul s;
			
				try {
					ctx2 = new InitialContext();
					s =  (RemoteVehicul) ctx2.lookup("/WebServeco/VehiculCrud!BusinessLogic.RemoteVehicul");
					 c.setId(Integer.parseInt(ct.getValueAt(table_1.getSelectedRow(),0).toString()));
			//c.setId(1);
					System.out.println(c.getId());
					 s.delete(c);
					
					      ct.deleteRow(table_1.getSelectedRow());
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});

		
		textField = new JTextField();
		textField.setBounds(113, 144, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
		
		
		
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(113, 63, 77, 20);
		RemoteSupplier sc;
		Context ctxy;
        List<Supplier> suppliers=new ArrayList<Supplier>();
        try {
			ctxy = new InitialContext();
			sc = (RemoteSupplier) ctxy.lookup("/WebServeco/SupplierCrud!BusinessLogic.RemoteSupplier");	
		     suppliers=sc.afficherSup();
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
		comboBox_1.setBounds(113, 187, 77, 20);
		
		RemoteService c;
		Context ctx1;
        List<Categorie> categories=new ArrayList<Categorie>();
        try {
			ctx1 = new InitialContext();
			c = (RemoteService) ctx1.lookup("/WebServeco/ServiceCrud!BusinessLogic.RemoteService");	
		     categories=c.afficher();
		     for (Categorie so:categories) {
					
		           comboBox_1.addItem(so.getName());
		           System.out.println(so.getName());
		       }
        } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contentPane.add(comboBox_1);
		
		JButton btnAddNewService = new JButton("Add new Vehicule");
		btnAddNewService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Vehicul c=new Vehicul();
			
				Context ctx;
				RemoteVehicul s;
				c.setType(textField.getText());
				c.setNomsupplier(comboBox.getSelectedItem().toString());
				Categorie catg =new Categorie();
				c.setImage(textField_1.getText());
				String service=comboBox_1.getSelectedItem().toString();
		//	Categorie catg=
					RemoteService rs;
					Context ctxc;
					try {
						ctxc = new InitialContext();
						rs = (RemoteService) ctxc.lookup("/WebServeco/ServiceCrud!BusinessLogic.RemoteService");
			
					 catg=rs.findByName(service);	        
						        
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
					c.setCategories(catg);
				try {
					ctx = new InitialContext();
					s =  (RemoteVehicul) ctx.lookup("/WebServeco/VehiculCrud!BusinessLogic.RemoteVehicul");
			
					
					s.add(c);
					VehiculT ct=(VehiculT) table_1.getModel();
					c.setId(table.getRowCount()+1);
					        ct.addRow(c);
					        
					        
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
	
		btnAddNewService.setBounds(51, 330, 156, 29);
		contentPane.add(btnAddNewService);
		
		JLabel lblName = new JLabel("Type");
		lblName.setBounds(26, 147, 46, 14);
		contentPane.add(lblName);
		
	
		
		JLabel lblSelectSupplier = new JLabel("select supplier");
		lblSelectSupplier.setBounds(10, 66, 77, 14);
		contentPane.add(lblSelectSupplier);
		
		JLabel lblSelectService = new JLabel("Select service");
		lblSelectService.setBounds(10, 190, 86, 14);
		contentPane.add(lblSelectService);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 66, 320, 223);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new VehiculT());
		scrollPane.setViewportView(table_1);
		
		JButton btnUploadImage = new JButton("upload image");
		btnUploadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upload(e);
			}
		});
		btnUploadImage.setBounds(95, 275, 112, 29);
		contentPane.add(btnUploadImage);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 279, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
	}
}
