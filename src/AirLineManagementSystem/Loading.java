package AirLineManagementSystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


//Multiple inheritances are allowed(interface multiple inheritances)
@SuppressWarnings("serial")
public class Loading extends JFrame implements Runnable {
	
	
	private JPanel contentPane;
	private JProgressBar progressBar;
	Connection conn;
	int s;
	Thread th;
	
	public static void main(String[] args) {
		new Loading().setVisible(true);
	}
	
	public void setUploading() {
		setVisible(false);
		th.start();
	}
	
	public void run() {
		try {
			for(int i = 0;i < 200; i++) {
				s = s + 1;
				
				int m = progressBar.getMaximum();//Maximum value will be 100 Bydefault
				int v = progressBar.getValue();
				if(v < m) {
					progressBar.setValue(progressBar.getValue() + 1);
				}
				else {
					i = 201; 
					setVisible(false);
					new Mainframe().setVisible(true);
				}
				Thread.sleep(50);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public Loading() {
			//Super must be the first statement to be called in the Constructor.
			super("Loading");
			th  = new Thread((Runnable) this);
			
			setBounds(600,300,600,400);
			contentPane = new JPanel();
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
//			JLabel lbllibraryManagement = new JLabel("Smart Library V1.0");
			JLabel lbl = new JLabel("Loading you in.");
			lbl.setForeground(new Color(72,209,204));
			lbl.setFont(new Font("Lucida Bright",Font.PLAIN,30));
			lbl.setBounds(130,46,500,35);
			contentPane.add(lbl);
			
			progressBar = new JProgressBar();
			progressBar.setFont(new Font("Lucida Bright",Font.BOLD,12));
			progressBar.setStringPainted(true);
			progressBar.setBounds(130,135,300,25);
			contentPane.add(progressBar);
			
			JLabel lblNewLabel_2 = new JLabel("Please wait....");
			lblNewLabel_2.setFont(new Font("Lucida Bright",Font.BOLD,20));
			lblNewLabel_2.setForeground(new Color(160,82,45));
			lblNewLabel_2.setBounds(200,165,150,20);
			contentPane.add(lblNewLabel_2);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0,0,590,390);
			contentPane.add(panel);
			
			setUploading();
		}
	}



