package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;







import BusinessLogic.IAuth;
import BusinessLogic.RemoteSignUp;
import entities.Admin;
import entities.SuperAdmin;

public class Authentification extends javax.swing.JFrame  {
	  private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JDialog jDialog1;
	    private javax.swing.JDialog jDialog2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JOptionPane jOptionPane1;
	    private javax.swing.JOptionPane jOptionPane2;
	    private javax.swing.JPasswordField jPasswordL;
	    private javax.swing.JTextField jTextField1;
	/**
	 * 
	 */
	 
	private static final long serialVersionUID = 1L;
	public Authentification()
	{
		  initComponents();
	        this.setSize(800,520);
	        this.setTitle("WebServeco Authentification");
	        this.setLocationRelativeTo(this);
	}
	
	 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
	 {
		 new Subscribe().setVisible(true);
		 this.setVisible(false);
		 
	 }
	
	  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
	        // TODO add your handling code here:
SuperAdmin a=new SuperAdmin();
Admin admin= new Admin();
admin.setLogin(jTextField1.getText());
admin.setPasswd(jPasswordL.getText());
	        a.setLogin(jTextField1.getText());
	        a.setPasswd(jPasswordL.getText());
	        SuperAdmin a2=new SuperAdmin();	
	Admin admin2=new Admin();
			IAuth c = null;
RemoteSignUp cc=null;
			try {
				Context ctx = new InitialContext();
				c = (IAuth) ctx.lookup("/WebServeco/RemoteAuth!BusinessLogic.IAuth");
		a2=c.Auth(jTextField1.getText(),jPasswordL.getText());
		 System.out.println(a2.getLogin()+""+a2.getPasswd());
	
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		try {
				Context ctx2 = new InitialContext();
				cc =  (RemoteSignUp) ctx2.lookup("/WebServeco/SignUp!BusinessLogic.RemoteSignUp");
		admin2=cc.Auth(jTextField1.getText(),jPasswordL.getText());
		     System.out.println(admin2.getLogin()+""+admin2.getPasswd());
	
		 
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	  
	       if((a.getLogin().equals(a2.getLogin()))&&(a.getPasswd().equals(a2.getPasswd())))
	        {
	    	   
	          new SuperM().setVisible(true);
	            this.setVisible(false);
	        }
	      
	       else if((admin.getLogin().equals(admin2.getLogin()))&&(admin.getPasswd().equals(admin2.getPasswd())))
	        {
	    	   
	           new UIAdmin(admin2).setVisible(true);
	            this.setVisible(false);
	        }  
	       
	       else{

	            jOptionPane1.showMessageDialog(null,"Error Login or password is not valid");
	        }
	        //                System.out.println("erreur mot de passe incorrect");
	}//GEN-LAST:event_jButton1ActionPerformed
	
	  private void initComponents() {

	        jDialog1 = new javax.swing.JDialog();
	        jOptionPane1 = new javax.swing.JOptionPane();
	        jDialog2 = new javax.swing.JDialog();
	        jOptionPane2 = new javax.swing.JOptionPane();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jPasswordL = new javax.swing.JPasswordField();
	        jTextField1 = new javax.swing.JTextField();
	        jLabel1 = new javax.swing.JLabel();

	        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
	        jDialog1.getContentPane().setLayout(jDialog1Layout);
	        jDialog1Layout.setHorizontalGroup(
	            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 400, Short.MAX_VALUE)
	        );
	        jDialog1Layout.setVerticalGroup(
	            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 300, Short.MAX_VALUE)
	        );

	        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
	        jDialog2.getContentPane().setLayout(jDialog2Layout);
	        jDialog2Layout.setHorizontalGroup(
	            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 400, Short.MAX_VALUE)
	        );
	        jDialog2Layout.setVerticalGroup(
	            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGap(0, 300, Short.MAX_VALUE)
	        );

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);

	        jButton1.setBackground(new java.awt.Color(204, 255, 255));
	        jButton1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
	        jButton1.setText("CONNEXION");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });
	        getContentPane().add(jButton1);
	        jButton1.setBounds(310, 400, 200, 40);

	        //button 2
	        jButton2.setBackground(new java.awt.Color(255, 205, 255));
	        jButton2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
	        jButton2.setText("Sign Up");
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });
	        getContentPane().add(jButton2);
	        jButton2.setBounds(310, 152, 200, 40);
	        //
	 

	        jPasswordL.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            //    jPasswordLActionPerformed(evt);
	            }
	        });
	        getContentPane().add(jPasswordL);
	        jPasswordL.setBounds(246,332, 280, 42);
	        getContentPane().add(jTextField1);
	        jTextField1.setBounds(246,276, 280, 42);

	        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
	        jLabel1.setFont(new java.awt.Font("Vrinda", 0, 36)); // NOI18N
	      

	        //
	   jLabel1.setIcon(new javax.swing.ImageIcon("C:\\login.jpg")); // NOI18N
	     
	   jLabel1.setBounds(0, -110, 1620, 700);
	      getContentPane().add(jLabel1);
	     
	      
	        validate();
	        pack();
	        
	    }// </editor-fold>//GEN-END:initComponents
	
	
	  
	    public static void main(String args[]) {

	 

	    	        java.awt.EventQueue.invokeLater(new Runnable() {
	    	            public void run() {
	    	                new Authentification().setVisible(true);
	    	                
	    	            }
	    	        });
	    	    }
}
