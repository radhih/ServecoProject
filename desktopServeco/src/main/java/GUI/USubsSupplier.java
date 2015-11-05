package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.JTable;

import BusinessLogic.ISbuscriptionSupplier;
import BusinessLogic.RemoteSupplier;
import TModel.SubsSuppliersT;
import entities.Admin;
import entities.SubscriptionSupplier;

import javax.swing.JScrollPane;

public class USubsSupplier extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton buttonV;
	private JButton buttonR;

private JOptionPane jOptionPane1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					USubsSupplier frame = new USubsSupplier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	 public Admin a =new Admin();
	public void bntHome(java.awt.event.ActionEvent e)
	{	
		this.setVisible(false);
		new UIAdmin(admin).setVisible(true);
	
		
	}
	 public void actionB(java.awt.event.ActionEvent e)
	 {
		 this.setVisible(false);
		 new UISupplier(admin).setVisible(true);
	 }
	public void btnLogout(java.awt.event.ActionEvent e)
	{	
		this.setVisible(false);
	
		new Authentification().setVisible(true);
	
	}
	public void actionB2(java.awt.event.ActionEvent e)
	{
		new USubsSupplier(admin).setVisible(true);
	}
	/**
	 * Create the frame.
	 */
	public USubsSupplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 62, 501, 288);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Button buttonT = new Button("Validate");
		buttonT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonT.setBounds(600, 129, 92, 53);
		contentPane.add(buttonT);
		
		Button buttonTT = new Button("Reject");
		buttonTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonTT.setBounds(600, 235, 92, 53);
		contentPane.add(buttonTT);
	}

	Admin admin=new Admin();
	private JScrollPane scrollPane;
public USubsSupplier(Admin a)
{
	

	admin=a;
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(350, 200, 750, 400);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	scrollPane = new JScrollPane();
	scrollPane.setBounds(38, 62, 501, 288);
	contentPane.add(scrollPane);
	table = new JTable();
	table.setBounds(38, 62, 501, 288);
	System.out.println("l"+a.getService());
	table.setModel(new SubsSuppliersT(a.getService()));
	scrollPane.setViewportView(table);
	Button button = new Button("Home");
	button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
	button.setBounds(0, 0, 98, 45);
	contentPane.add(button);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		bntHome(e);
		
		}
	});
	Button button_1 = new Button("Suppliers");
	button_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
	button_1.setBackground(SystemColor.inactiveCaptionBorder);
	button_1.setBounds(104, 0, 92, 45);
	contentPane.add(button_1);
	button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		actionB(e);
		}
	});
	Button button_2 = new Button("Managment");
	button_2.setFont(new Font("Dialog", Font.PLAIN, 14));
	button_2.setBounds(202, 0, 115, 45);
	contentPane.add(button_2);
	button_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		actionB2(e);
		
		}
	});
	
	Button button_3 = new Button("LogOut");
	button_3.setFont(new Font("Dialog", Font.PLAIN, 14));
	button_3.setBounds(323, 0, 98, 45);
	contentPane.add(button_3);
	button_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		btnLogout(e);
		
		}
	});
	Button buttonT = new Button("Validate");
	buttonT.setBounds(600, 129, 92, 53);
	contentPane.add(buttonT);
	buttonT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
		
	        SubsSuppliersT ct=(SubsSuppliersT) table.getModel();
					SubscriptionSupplier c=new SubscriptionSupplier();
					
					Context ctx2;
					ISbuscriptionSupplier s;
				
					try {
						ctx2 = new InitialContext();
						s =  (ISbuscriptionSupplier) ctx2.lookup("/WebServeco/SubscriptionSupplierCrud!BusinessLogic.ISbuscriptionSupplier");
						 c.setId(Integer.parseInt(ct.getValueAt(table.getSelectedRow(),0).toString()));
					System.out.println(c.getId());
Boolean t;
			t=s.updateSubs(c);
if(t)
{		jOptionPane1.showMessageDialog(null,"Subscription has been Accepted");
new UIMail().setVisible(true);
}
else
{
	jOptionPane1.showMessageDialog(null,"Connexion refused!!");
	
}
						   //ct.deleteRow(table.getSelectedRow());
						  //String MailR=ct.getValueAt(table.getSelectedRow(),7).toString();
						  //System.out.println(MailR); 
			
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							
		
		
		}
	});
	Button buttonTT = new Button("Reject");
	buttonTT.setBounds(600, 235, 92, 53);
	contentPane.add(buttonTT);
	buttonTT.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			 SubsSuppliersT ct=(SubsSuppliersT) table.getModel();
				SubscriptionSupplier c=new SubscriptionSupplier();
				
				Context ctx2;
				ISbuscriptionSupplier s;
			
				try {
					ctx2 = new InitialContext();
					s =  (ISbuscriptionSupplier) ctx2.lookup("/WebServeco/SubscriptionSupplierCrud!BusinessLogic.ISbuscriptionSupplier");
					 c.setId(Integer.parseInt(ct.getValueAt(table.getSelectedRow(),0).toString()));
				System.out.println(c.getId());
Boolean t=false;
		t=s.DeleteSubs(c);

		
if(t)
{		jOptionPane1.showMessageDialog(null,"Subscription has been Refused");
new UIMail().setVisible(true);

}
else
{
jOptionPane1.showMessageDialog(null,"Connexion refused!!");

}
					   //ct.deleteRow(table.getSelectedRow());
					  //String MailR=ct.getValueAt(table.getSelectedRow(),7).toString();
					  //System.out.println(MailR); 
		
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		
		
		
		
		}
	});
	
	

}	
}
