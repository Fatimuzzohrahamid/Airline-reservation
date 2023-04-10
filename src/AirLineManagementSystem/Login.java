
package AirLineManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1l;
//	private static final int BOLD = 0;
	private JPanel panel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton b1,b2,b3;
	
	public Login() {
		
//		setLayout(null);
		setBackground(new Color(169,169,169));
		setBounds(600,300,600,400);
		
		panel = new JPanel();
		panel.setBackground(new Color(179,224,230));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel l1 =  new JLabel("UserName : ");
		l1.setBounds(124,89,95,24);
		panel.add(l1);
		
		JLabel l2 =  new JLabel("PassWord : ");
		l2.setBounds(124,124,95,24);
		panel.add(l2);
		
		textField = new JTextField();
		textField.setBounds(210,93,157,20);
		panel.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(210,128,157,20);
		panel.add(passwordField);
		
		
		b1 = new JButton("Login");
		b1.addActionListener(this);
		b1.setForeground(new Color(46,139,87));
		b1.setBackground(new Color(250,250,210));
		b1.setBounds(149,181,113,39);
		panel.add(b1);
		
		b2 = new JButton("Register");
		b2.addActionListener(this); 	
		
		b2.setForeground(new Color(139,69,19));
		b2.setBackground(new Color(255,250,210));
		b2.setBounds(289,181,113,39);
		panel.add(b2);
		
		b3 = new JButton("Forgotten_Password ");
		b3.addActionListener(this); 	
		
		b3.setForeground(new Color(205,92,92));
		b3.setBackground(new Color(255,250,210));
		b3.setBounds(199,231,179,39);
		panel.add(b3);
//		
//		JLabel l3 = new JLabel("Trouble in Login");
//		l3.setFont(new Font("CascadiaCode",BOLD,16));
//		l3.setForeground(new Color(255,0,0));
//		l3.setBounds(30,210,130,30);
//		panel.add(l3);
		
		JLabel l4 = new JLabel("Logining you in...!");
		l4.setFont(new Font("Lucida Bright",Font.BOLD,25));
		l4.setForeground(new Color(255,0,0));
		l4.setBounds(210,30,250,50);
		panel.add(l4);
		
//		JPanel panel2 = new JPanel();
//		panel2.setBackground(new Color(255,250,210));
//		panel2.setBounds(70,240,130,20);
//		panel.add(panel2);
	}

	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1)
		{
			Boolean status = false;
			try{
				conn con = new conn();
				String sql ="select * from login  where username = ? and password = ?";
				PreparedStatement st = con.c.prepareStatement(sql);
				
				st.setString(1, textField.getText());
				st.setString(2, passwordField.getText());
				
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					this.setVisible(false);
					new Loading().setVisible(true);
				}
				else JOptionPane.showMessageDialog(null,"Invalid Login..!");
								
			}catch(Exception e2) {
				e2.printStackTrace();
			}
			
		}
		if(ae.getSource() == b2) {
			setVisible(false);
			Signup su = new Signup();
			su.setVisible(true);
		}
		if(ae.getSource() == b3) {
			setVisible(false);
			Forgot forgot = new Forgot();
			forgot.setVisible(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login().setVisible(true);
	}

}


//package AirLineManagementSystem;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener{
//    
//    TextField t1,t2;
//    Label l1,l2;
//    Button b2,b3,b4;
//    GridBagLayout gbl;  
//    GridBagConstraints gbc; 
//    Font f1,f2;
//    
//    public Login(){
//        super("Login");
//                
//        setBackground(Color.WHITE); 
//        f1 = new Font("TimesRoman",Font.BOLD,20);
//        f2 = new Font("TimesRoman",Font.BOLD,15);
//		
//        gbl=new GridBagLayout(); 
//	gbc=new GridBagConstraints();
//        setLayout(gbl); 
//	
//        l1 = new Label("Username");
//        l1.setFont(f1);
//	
//        l2 = new Label("Password");
//        l2.setFont(f1);
//
//	
//        t1 = new TextField(15); 
//	t2 = new TextField(15); 
//        t2.setEchoChar('*');
//	
//	b2 = new Button("Reset");
//        b2.setFont(f2);
//		
//        b3 = new Button("Submit");
//        b3.setFont(f2);
//		
//        b4 = new Button("Close");
//	b4.setFont(f2);
//		
//        gbc.gridx=0;
//	gbc.gridy=0; 
//        gbl.setConstraints(l1,gbc);
//	add(l1);
//        
//	gbc.gridx=2;
//        gbc.gridy=0;
//	gbl.setConstraints(t1,gbc);
//        add(t1);
//		
//	gbc.gridx=0;
//        gbc.gridy=2;
//	gbl.setConstraints(l2,gbc);
//        add(l2);
//
//	gbc.gridx=2;
//        gbc.gridy=2;
//        gbl.setConstraints(t2,gbc);
//	add(t2);
//				
//	
//	gbc.gridx=0;
//        gbc.gridy=8;
//	gbl.setConstraints(b2,gbc);
//        add(b2);
//
//        gbc.gridx=2;
//	gbc.gridy=8;
//        gbl.setConstraints(b3,gbc);
//	add(b3);
//	
//        gbc.gridx=4;
//	gbc.gridy=8;
//        gbl.setConstraints(b4,gbc);
//	add(b4);
//        
//
//        b2.addActionListener(this);
//        b3.addActionListener(this);
//	b4.addActionListener(this);
//                
//        setVisible(true);   
//        setSize(400,250); 
//        setLocation(400,200);   
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==b2){
//          
//            t1.setText("");  
//            t2.setText(""); 
//	}
//        if(ae.getSource()==b4){
//            System.exit(0); 
//	}
//        if(ae.getSource()==b3){
//            try{
//                conn c1 = new conn();
//                
//                String s1 = t1.getText();
//                String s2 = t2.getText();
//            
//                String str = "select * from login where username = '"+s1+"' and password = '"+s2+"'";
//                ResultSet rs = c1.s.executeQuery(str);  
//                
//                if(rs.next()){
//                    new Mainframe();
//                    setVisible(false);
//                }else{
//                    JOptionPane.showMessageDialog(null,"Invalid Login");
//                    setVisible(false); 
//                }
//            
//            }catch(Exception e){}
//            
//	}
//    }        
//   
//    public static void main(String[] args){
//            new Login();
//    }
//}