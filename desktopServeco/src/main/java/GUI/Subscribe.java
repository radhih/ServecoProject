package GUI;


import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;













import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.SystemColor;
import java.io.File;




import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import entities.Admin;
import entities.Categorie;
import BusinessLogic.IAuth;
import BusinessLogic.RemoteService;
import BusinessLogic.RemoteSignUp;








import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;


public class Subscribe extends JFrame {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JFileChooser jFileChooser1;
	private JButton b2;
	private JTextField jTextFieldF;

 private JOptionPane jOptionPane1;
 private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subscribe frame = new Subscribe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
private void action1(java.awt.event.ActionEvent evt)
{
	Authentification eAuthentification =new Authentification();
	eAuthentification.setVisible(true);
	this.setVisible(false);
}
public void action2(java.awt.event.ActionEvent evt)
{
	
	Admin admin =new Admin();
    admin.setFirstName(textField.getText());
    admin.setLastName(textField_1.getText());
admin.setMail(textField_2.getText());
admin.setPhoneNumbe(textField_3.getText());
admin.setLogin(textField_4.getText());
admin.setPasswd(passwordField.getText());
admin.setAge(Integer.parseInt(textField_5.getText().toString()));
admin.setSubs(false);
File f= jFileChooser1.getSelectedFile();
if(passwordField.getText()=="" || textField_2.getText()==""||jTextFieldF.getText()=="" ||f==null )
{
	jOptionPane1.showMessageDialog(null,"Please check your login password and your photo profil");
}
else{

byte[] bFile = new byte[(int) f.length()];

try {

FileInputStream fileInputStream = new FileInputStream(f);
fileInputStream.read(bFile);
fileInputStream.close();
} catch (Exception e) {
e.printStackTrace();
 
}   

admin.setImage(bFile);





boolean bool;
RemoteSignUp c;
Context ctx;
boolean a = false;
try {
	ctx = new InitialContext();
	c = (RemoteSignUp) ctx.lookup("/WebServeco/SignUp!BusinessLogic.RemoteSignUp");
bool=c.verifyLogin(textField_4.getText());
if(bool)
{
	jOptionPane1.showMessageDialog(null," Login already exist");
}
else{
a=c.signup(admin);
	System.out.println(a);
}
if(a)
	{
		jOptionPane1.showMessageDialog(null,"successful ");
		this.setVisible(false);
		new Authentification().setVisible(true);
	}
	else
	{
		jOptionPane1.showMessageDialog(null,"Connexion error ");
		
	}
} catch (NamingException e) {
	// TODO Auto-generated catch block
    jOptionPane1.showMessageDialog(null,"All fields are required ");

	e.printStackTrace();
}

}






}


	/**
	 * Create the frame.
	 */
private void b2ActionPerformed(java.awt.event.ActionEvent evt) {
    JFileChooser chooser=new JFileChooser();
    jFileChooser1.showOpenDialog(null);
     File f=jFileChooser1.getSelectedFile();
     String filename=f.getAbsolutePath();
     jTextFieldF.setText(filename);
   
 }
	public void initComponents()
	{
		//filechooser
		
		jFileChooser1 = new JFileChooser();
		
		//
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		jTextFieldF=new JTextField();
		jTextFieldF.setBounds(360,290,100,20);
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(27, 28, 102, 14);
		contentPane.add(lblFirstName);
		contentPane.add(jTextFieldF);
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(27, 53, 92, 14);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(37, 87, 64, 14);
		contentPane.add(lblEmail);
		
		JLabel lblMobileNumber = new JLabel("Mobile number:");
		lblMobileNumber.setBounds(10, 127, 91, 14);
		contentPane.add(lblMobileNumber);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(27, 165, 64, 14);
		contentPane.add(lblPassword);
		
		JLabel lblLogin = new JLabel("login:");
		lblLogin.setBounds(37, 222, 64, 14);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(139, 25, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 50, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 84, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(139, 124, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(139, 219, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.shadow"));
		panel.setBounds(341, 91, 364, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Upload your photo profil");
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBounds(47, 98, 205, 27);
		panel.add(lblNewLabel);
		
	
		b2= new JButton();
		b2.setBounds(133, 207, 140, 23);
		panel.add(b2);
		b2.setBackground(new java.awt.Color(179, 255, 153));
		b2.setFont(new java.awt.Font("Bookman Old Style", 1, 12));
		b2.setText("Upload");
		b2.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        b2ActionPerformed(evt);
		    }
		});
		
		Button button = new Button("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				action1(e);
				
			}
		});
		button.setActionCommand("Submit");
		button.setBounds(47, 398, 113, 31);
		contentPane.add(button);
		
		Button button_1 = new Button("Submit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			action2(e);
			}
		});
		button_1.setBounds(213, 388, 134, 41);
		contentPane.add(button_1);
		
		Label label = new Label("Age:");
		label.setBounds(39, 292, 62, 22);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 162, 86, 20);
		contentPane.add(passwordField);
		
		textField_5 = new JTextField();
		textField_5.setBounds(139, 279, 48, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
	
		
		
	}
	public Subscribe() {
		initComponents();
		 this.setSize(800,520);
	        this.setTitle("Subscription");
	        this.setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//	setBounds(100, 100, 475, 329);
		
	}
}
