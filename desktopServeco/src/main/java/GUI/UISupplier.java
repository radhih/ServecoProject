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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import BusinessLogic.RemoteSupplier;
import TModel.SupplierT;
import entities.Admin;
import entities.Note;
import entities.Supplier;

import javax.swing.JButton;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class UISupplier extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JOptionPane jOptionPane1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UISupplier frame = new UISupplier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fire(int id , Admin a)
	{
	int reply = jOptionPane1.showConfirmDialog(null,"Are You Sure You want To Fire The Supplier","Fire Supplier", JOptionPane.YES_NO_OPTION);
	  if (reply == JOptionPane.YES_OPTION)
		{
			RemoteSupplier c;
		Context ctxr;
		try {
			ctxr = new InitialContext();
			c = (RemoteSupplier) ctxr.lookup("/WebServeco/SupplierCrud!BusinessLogic.RemoteSupplier");
		c.removeSup(id);
		jOptionPane1.showMessageDialog(null,"Supplier Fired");
		this.setVisible(false);
		new UISupplier(a).setVisible(true);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			jOptionPane1.showMessageDialog(null,"Error");
			e.printStackTrace();
		}		
	   }
	}
    public void Blame(int id)
    {
    	JFrame frame = new JFrame("InputDialog Example #2");
    	String blameMsg = JOptionPane.showInputDialog( frame, "Enter your Message here",  "Blame To Send", JOptionPane.WARNING_MESSAGE);
    	if(blameMsg !=null)
    	{
    	RemoteSupplier c;
		Context ctx;
		try {
			ctx = new InitialContext();
			c = (RemoteSupplier) ctx.lookup("/WebServeco/SupplierCrud!BusinessLogic.RemoteSupplier");
		c.BlameSup(id,blameMsg);
		jOptionPane1.showMessageDialog(null,"Blame Sent");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			jOptionPane1.showMessageDialog(null,"Error");
			
			e.printStackTrace();
		}		
       }
    }
	/**
	 * Create the frame.
	 */
	
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
		this.setVisible(false);
		new USubsSupplier(admin).setVisible(true);
	}
	public UISupplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 756, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 502, 283);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLocalize = new JButton("Localize");
		btnLocalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLocalize.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnLocalize.setBackground(Color.GREEN);
		btnLocalize.setBounds(519, 230, 113, 42);
		contentPane.add(btnLocalize);
		
		JButton btnNoteSupplier = new JButton("Note Supplier");
		btnNoteSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNoteSupplier.setBounds(570, 90, 89, 23);
		contentPane.add(btnNoteSupplier);
		
		textField = new JTextField();
		textField.setBounds(573, 124, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	public Admin admin;
	private JTextField textField;
	public UISupplier(Admin a)
	{
		UIManager.put("OptionPane.yesButtonText", "Yes");
		UIManager.put("OptionPane.noButtonText", "No");
		UIManager.put("OptionPane.cancelButtonText", "Cancel");
		admin=a;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 433, 283);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		String service=a.getService();
		System.out.println("pppppppppppp"+service);
		table.setModel(new SupplierT(service));
		
		
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
		JButton btnNoteSupplier = new JButton("Note Supplier");
		btnNoteSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 SupplierT ct= (SupplierT) table.getModel();
			int i= (int) ct.getValueAt(table.getSelectedRow(),0);
			RemoteSupplier c;
			Context ctx2;
			Supplier s=new Supplier();

			List<Note> notes=new ArrayList<Note>();
			
			try {
				ctx2 = new InitialContext();
				c = (RemoteSupplier) ctx2.lookup("/WebServeco/SupplierCrud!BusinessLogic.RemoteSupplier");
			s=c.findBy(i);
			

notes=s.getNotes();
int l=notes.size();
float somme=0;
for(Note so:notes)
{
	somme +=so.getNoteSup();
}
textField.setEditable(false);
float moyenne=somme/l;
textField.setText((Float.toString( moyenne)));
			} catch (NamingException ee) {
				// TODO Auto-generated catch block
				jOptionPane1.showMessageDialog(null,"Error");
				
				ee.printStackTrace();
			}		
			
		
			}
		});
		btnNoteSupplier.setBounds(570, 90, 89, 23);
		contentPane.add(btnNoteSupplier);
		
		textField = new JTextField();
		textField.setBounds(573, 124, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);	
		Button button_3 = new Button("LogOut");
		button_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		button_3.setBounds(323, 0, 98, 45);
		contentPane.add(button_3);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			btnLogout(e);
			
			}
		});	
		JButton btnLocalize = new JButton("GeoTag");
		btnLocalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				  SupplierT ct= (SupplierT) table.getModel();
				String a=(String) ct.getValueAt(table.getSelectedRow(),6);

				  //String a="Tunis,+Tunisie";
				String gps="6.423601,79.996755";
				Maps maps=new Maps(gps,a);
				maps.show(gps, a);	
			
			
			}
		});
		btnLocalize.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnLocalize.setBackground(Color.GREEN);
		btnLocalize.setBounds(519, 230, 113, 42);
		contentPane.add(btnLocalize);
		JButton btnFire = new JButton("Fire");
		btnFire.setBounds(615, 271, 109, 28);
		contentPane.add(btnFire);
		btnFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fire((int)table.getModel().getValueAt(table.getSelectedRow(),0),admin);		
			}
		});
		
		JButton btnBlame = new JButton("Blame");
		btnBlame.setBounds(615, 196, 109, 28);
		contentPane.add(btnBlame);
		btnBlame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Blame((int)table.getModel().getValueAt(table.getSelectedRow(),0));
			}
		});
	

	}
}
