package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Bill;
import entities.Reservation;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import BusinessLogic.RemoteReserv;

public class UIBill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
    private javax.swing.JOptionPane jOptionPane1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIBill frame = new UIBill();
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
	public void actionBack(java.awt.event.ActionEvent e)
	{
		this.setVisible(false);
	}
	
	
	public UIBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 578, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectThePrice = new JLabel("Select the price");
		lblSelectThePrice.setBounds(29, 98, 138, 30);
		contentPane.add(lblSelectThePrice);
		
		JButton btnNewButton = new JButton("Submit the bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.setBounds(204, 232, 157, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(27, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(204, 103, 98, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	public UIBill(final Reservation r) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 578, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(204, 103, 98, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel lblSelectThePrice = new JLabel("Select the price");
		lblSelectThePrice.setBounds(29, 98, 138, 30);
		contentPane.add(lblSelectThePrice);
		
		JButton btnNewButton = new JButton("Submit the bill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		Bill b =new Bill();
		b.setNameclient(r.getClient().getFirstName());
		b.setNamesupplier(r.getNamesupplier());
		b.setPrice(textField.getText());
		b.setTypevehicul(r.getVehicul().getType());
		b.setReservation(r);
				RemoteReserv cc;
				Context ctx2;
	
		
			Reservation r=new Reservation();
			try {
				
				ctx2 = new InitialContext();
				cc =  (RemoteReserv) ctx2.lookup("/WebServeco/ReservCrud!BusinessLogic.RemoteReserv");
				System.out.println(r.isStatus());

   cc.addbill(b);
		jOptionPane1.showMessageDialog(null,"A bill has been generated with success ");
 
	
		
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.setBounds(204, 232, 157, 56);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			actionBack(e);
			}
		});
		btnNewButton_1.setBounds(27, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
