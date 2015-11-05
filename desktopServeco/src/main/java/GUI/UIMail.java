package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import service.Mail;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIMail extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 8728162357031506707L;
private JOptionPane  JOptionPane;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIMail frame = new UIMail();
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
	public UIMail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(82, 60, 174, 31);
		contentPane.add(textField);
		textField.setColumns(10);
	
		JLabel lblTo = new JLabel("TO:");
		lblTo.setBounds(10, 68, 46, 14);
		contentPane.add(lblTo);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(85, 138, 190, 90);
		contentPane.add(textArea);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     try{
				       Mail.send("smtp.orange.tn",textField.getText(),"Serveco@esprit.tn",null,textArea.getText());
				       JOptionPane.showMessageDialog(null, "Your mail has been sent with success");
			
			     }
				       catch(Exception ee){
				       JOptionPane.showMessageDialog(null, "Connexion fails");    
				       }
			}
		});
		btnSend.setBounds(109, 238, 89, 23);
		contentPane.add(btnSend);
		
		JLabel lblRejection = new JLabel("E-Mail");
		lblRejection.setBounds(82, 11, 127, 38);
		contentPane.add(lblRejection);
	}
	public UIMail(String MailR)
	{setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	textField = new JTextField();
	textField.setBounds(82, 60, 174, 31);
	contentPane.add(textField);
	textField.setColumns(10);
	textField.setEditable(false);
textField.setText(MailR);
	JLabel lblTo = new JLabel("TO:");
	lblTo.setBounds(10, 68, 46, 14);
	contentPane.add(lblTo);
	
	final JTextArea textArea = new JTextArea();
	textArea.setBounds(85, 138, 190, 90);
	contentPane.add(textArea);
	
	JButton btnSend = new JButton("Send");
	btnSend.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		     try{
			       Mail.send("smtp.orange.tn",textField.getText(),"Serveco@esprit.tn",null,textArea.getText());
			       JOptionPane.showMessageDialog(null, "Your mail has been sent with success");
		
		     }
			       catch(Exception ee){
			       JOptionPane.showMessageDialog(null, "Connexion fails");    
			       }
		}
	});
	btnSend.setBounds(109, 238, 89, 23);
	contentPane.add(btnSend);
	
	JLabel lblRejection = new JLabel("Rejection ");
	lblRejection.setBounds(82, 11, 127, 38);
	contentPane.add(lblRejection);
	}
}
