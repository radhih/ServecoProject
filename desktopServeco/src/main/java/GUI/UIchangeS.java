package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import entities.Categorie;
import BusinessLogic.RemoteAdmin;
import BusinessLogic.RemoteService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIchangeS extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIchangeS frame = new UIchangeS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void b1(java.awt.event.ActionEvent e)
	{
		this.setVisible(false);
	}
	
	/**
	 * Create the frame.
	 */
	public UIchangeS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Validate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(222, 191, 121, 46);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(176, 47, 191, 20);
		contentPane.add(comboBox);
		
		JLabel lblSelectANew = new JLabel("Select a new service ");
		lblSelectANew.setBounds(22, 28, 144, 59);
		contentPane.add(lblSelectANew);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(0, 0, 102, 37);
		contentPane.add(btnNewButton_1);
	}
	public UIchangeS(final int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(176, 47, 191, 20);
		contentPane.add(comboBox);
		
		RemoteService c;
		Context ctx1;
        List<Categorie> categories=new ArrayList<Categorie>();
        try {
			ctx1 = new InitialContext();
			c = (RemoteService) ctx1.lookup("/WebServeco/ServiceCrud!BusinessLogic.RemoteService");	
		     categories=c.afficher();
		     for (Categorie so:categories) {
					
		           comboBox.addItem(so.getName());
		           System.out.println(so.getName());
		       }
        } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		JButton btnNewButton = new JButton("Validate");
		btnNewButton.setBounds(222, 191, 121, 46);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				RemoteAdmin c;
				Context ctx;
				try {
					ctx = new InitialContext();
					c =  (RemoteAdmin) ctx.lookup("/WebServeco/AdminCrud!BusinessLogic.RemoteAdmin");
					String service=comboBox.getSelectedItem().toString();
					c.updateService(service,id);
				
				} catch (NamingException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
				
				
				
			
			
			}
		});
		
	
		
		
		JLabel lblSelectANew = new JLabel("Select a new service ");
		lblSelectANew.setBounds(22, 28, 144, 59);
		contentPane.add(lblSelectANew);
		
		JButton btnNewButton_1 = new JButton("Go back");
		btnNewButton_1.setBounds(0, 0, 102, 37);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			b1(e);
			
			}
		});
	}

}
