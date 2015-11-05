package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import BusinessLogic.RemoteService;
import BusinessLogic.RemoteSignUp;
import BusinessLogic.RemoteSubscription;
import entities.Admin;
import entities.Categorie;
import entities.SubscriptionAdmin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class UIAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6987714927065791882L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    private javax.swing.JOptionPane jOptionPane1;
	private UIAdmin frame;
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIAdmin frame = new UIAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void bntHome(java.awt.event.ActionEvent e)
	{	
		this.setVisible(false);
		new UIAdmin(a).setVisible(true);
	
		
	}
	 public void actionB(java.awt.event.ActionEvent e)
	 {
		 this.setVisible(false);
		 new UISupplier(a).setVisible(true);
	 }
	public void btnLogout(java.awt.event.ActionEvent e)
	{	this.setVisible(false);
	
		new Authentification().setVisible(true);
	
	}
	public void actionB2(java.awt.event.ActionEvent e)
	{
		new USubsSupplier(a).setVisible(true);
	}
	/**
	 * Create the frame.
	 */public UIAdmin()
	 {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(350, 200, 750, 400);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			Panel panel = new Panel();
			panel.setBackground(SystemColor.desktop);
			panel.setForeground(new Color(153, 204, 255));
			panel.setBounds(451, 86, 273, 235);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JButton btnNewButton = new JButton("Subscribe");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.setBounds(75, 173, 105, 38);
			panel.add(btnNewButton);
			
			JLabel label = new JLabel("");
			label.setBounds(145, 16, 0, 0);
			panel.add(label);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(75, 69, 105, 23);
			panel.add(comboBox);
			
			JLabel lblGetStartedWith = new JLabel("Get started with Service subscription");
			lblGetStartedWith.setForeground(new Color(102, 204, 0));
			lblGetStartedWith.setFont(new Font("Lucida Console", Font.BOLD, 12));
			lblGetStartedWith.setBounds(10, 16, 253, 38);
			panel.add(lblGetStartedWith);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(10, 62, 231, 259);
			contentPane.add(lblNewLabel);
			
			Panel panel_1 = new Panel();
			panel_1.setBackground(SystemColor.inactiveCaptionBorder);
			panel_1.setBounds(247, 64, 162, 257);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(20, 49, 86, 20);
			panel_1.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(20, 91, 86, 20);
			panel_1.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(20, 147, 86, 20);
			panel_1.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblPersonalDetails = new JLabel("Personal Details");
			lblPersonalDetails.setBackground(SystemColor.inactiveCaptionBorder);
			lblPersonalDetails.setFont(new Font("Yu Gothic", Font.BOLD, 13));
			lblPersonalDetails.setForeground(new Color(153, 153, 255));
			lblPersonalDetails.setBounds(10, 11, 113, 32);
			panel_1.add(lblPersonalDetails);
			
			Button button = new Button("Home");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bntHome(e);
					//new UIAdmin().setVisible(true);
				}
			});
			button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			button.setBounds(0, 0, 98, 45);
			contentPane.add(button);
			
			Button button_1 = new Button("Suppliers");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			button_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			button_1.setBackground(SystemColor.inactiveCaptionBorder);
			button_1.setBounds(104, 0, 92, 45);
			contentPane.add(button_1);
			
			Button button_2 = new Button("Managment");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			button_2.setFont(new Font("Dialog", Font.PLAIN, 14));
			button_2.setBounds(202, 0, 115, 45);
			contentPane.add(button_2);
			
			Button button_3 = new Button("LogOut");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			
					btnLogout(e);
				}
			});
			button_3.setFont(new Font("Dialog", Font.PLAIN, 14));
			button_3.setBounds(323, 0, 98, 45);
			contentPane.add(button_3);
			
			JButton btnNewButton_1 = new JButton("Claim Managment");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_1.setBounds(424, 0, 123, 45);
			contentPane.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Accidents managment");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_2.setBounds(550, 0, 142, 45);
			contentPane.add(btnNewButton_2);
	
		
	 }

	 public Admin a =new Admin();
	public UIAdmin(Admin admin2) {
		a=admin2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 200, 750, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(SystemColor.desktop);
		panel.setForeground(new Color(153, 204, 255));
		panel.setBounds(451, 86, 273, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		final JButton btnNewButton = new JButton("Subscribe");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(75, 173, 105, 38);
		panel.add(btnNewButton);	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 62, 231, 259);
		
		JLabel label = new JLabel("");
		label.setBounds(145, 16, 0, 0);
		JLabel lblGetStartedWith = new JLabel("Get started with Service subscription");
		lblGetStartedWith.setForeground(new Color(102, 204, 0));
		lblGetStartedWith.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblGetStartedWith.setBounds(10, 16, 253, 38);
		panel.add(lblGetStartedWith);
		
		Image image;
		  image=getToolkit().createImage(admin2.getImage());
		  ImageIcon imageicon=new ImageIcon(image);
		  lblNewLabel.setIcon(imageicon);
		  panel.add(label);
		  contentPane.add(lblNewLabel);
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(75, 69, 105, 23);
	
		Panel panel_1 = new Panel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(247, 64, 162, 257);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(20, 49, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 91, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(20, 147, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPersonalDetails = new JLabel("Personal Details");
		lblPersonalDetails.setBackground(SystemColor.inactiveCaptionBorder);
		lblPersonalDetails.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		lblPersonalDetails.setForeground(new Color(153, 153, 255));
		lblPersonalDetails.setBounds(10, 11, 113, 32);
		panel_1.add(lblPersonalDetails);
		
		Button button = new Button("Home");
		button.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		button.setBounds(0, 0, 98, 45);
		contentPane.add(button);
		
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
		
    	panel.add(comboBox);
    	textField.setText(a.getLogin());;
    	textField_1.setText(a.getFirstName());;
    	textField_2.setText(a.getService());;
    	textField.setEditable(false);
    	textField_1.setEditable(false);
    	textField_2.setEditable(false);
    	System.out.println(a.getService());		
    	JButton btnNewButton_2 = new JButton("Accidents managment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		new UIaccident(a).setVisible(true);
			//System.out.println("sdqsd");
			}
		});
		btnNewButton_2.setBounds(550, 0, 142, 45);
		contentPane.add(btnNewButton_2);
    	
    	JButton btnNewButto_1 = new JButton("Claim Managment");
		btnNewButto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new ClaimManagment().setVisible(true);
			
			}
		});
    	if (a.getService()==null)
		{
		btnNewButton.setVisible(true);

		}
		else{
			btnNewButton.setVisible(false);
		}
	if(a.isSubs())
	{btnNewButton_2.setVisible(true);
		button_1.setVisible(true);
		button_2.setVisible(true);
		btnNewButto_1.setVisible(true);
	}
	else
	{button_2.setVisible(false);
		button_1.setVisible(false);
		btnNewButton_2.setVisible(false);
		btnNewButto_1.setVisible(false);
	}
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		btnLogout(e);
			}
		});
    	
    	button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		bntHome(e);
			

			}
		});
    	
    	
		btnNewButto_1.setBounds(424, 0, 123, 45);
		contentPane.add(btnNewButto_1);
    	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				SubscriptionAdmin sbs =new SubscriptionAdmin();
				RemoteSubscription c;
				RemoteService cc;
				Context ctx;
				Context ctx2;
				Categorie cat=new Categorie();
				SubscriptionAdmin s=new SubscriptionAdmin();
				try {
					ctx = new InitialContext();
					c = (RemoteSubscription) ctx.lookup("/WebServeco/subsCrud!BusinessLogic.RemoteSubscription");			
					sbs.setStatus("demanded");
					sbs.setMail(a.getMail());
					sbs.setLogin(textField.getText());
					sbs.setName(textField_1.getText());
					ctx2 = new InitialContext();
					cc = (RemoteService) ctx.lookup("/WebServeco/ServiceCrud!BusinessLogic.RemoteService");			
					
					
				
					String desc=comboBox.getSelectedItem().toString();
					sbs.setDescription(desc);
					cat=cc.findByName(desc);
					sbs.setServiceAdmin(cat);
					System.out.println("\n\n admin id "+a.getId());
					a.setSub(sbs);
					a.setService("not yet");
					sbs.setAdmin(a);
				
					
					
					System.out.println(a.getLogin());
					boolean t;
					t=c.subscribe(sbs);
					System.out.println(t);
		      
					if(t)
		          {
					jOptionPane1.showMessageDialog(null,"Your application has been registered");
		         btnNewButton.setVisible(false);
		    
		          }
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			
			}
			
			
			
		});
	
	}
}
