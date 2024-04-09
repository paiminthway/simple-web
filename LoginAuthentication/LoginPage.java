package LoginAuthentication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

import com.sun.xml.internal.ws.api.server.Container;

public class LoginPage implements ActionListener{
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton jBack = new JButton("Back");
	JTextField userIDField = new JTextField();
	
	JPasswordField userPasswordField = new JPasswordField();
	
	JLabel userIDLabel = new JLabel("UserID:");
	JLabel userPasswordLabel = new JLabel("Password: ");
	JLabel messageLabel = new JLabel("");	
	String[][] logininfo = new String[10][2];
	LoginPage(String[][] loginInfoOriginal){
		logininfo = loginInfoOriginal;
		//Label
		userIDLabel.setBounds(50,100,75,25);
		userIDLabel.setFont(new Font(null, Font.BOLD, 15));
		
		userPasswordLabel.setBounds(50,150,75,25);
		userPasswordLabel.setFont(new Font(null, Font.BOLD, 12));
		
		messageLabel.setBounds(120,0,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		//Field
		userIDField.setBounds(125,100,200,25);//Bound
		userPasswordField.setBounds(125,150,200,25);//Bound
		//Button
		java.awt.Container c = frame.getContentPane();
		c.setBackground(Color.getHSBColor(45, 40, 100));//Color
		
		loginButton.setBounds(125,200,100,25);// Button 
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225,200,100,25);// Button
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		jBack.setBounds(175,250,100,25);
		jBack.setFocusable(false);
		jBack.addActionListener(this);
		//Frame
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(jBack);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int userFound = 0;
		if(e.getSource() == jBack){
			frame.dispose();
			new Choice();
		}
		if(e.getSource() == resetButton){
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource() == loginButton){ // unser name and password checking
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			for(int i = 0; i< logininfo.length; i++){
				if(logininfo[i][0].equals(userID)){
					 userFound = 1;
					if(logininfo[i][1].equals(password)){
						
						frame.dispose();
						Captachas output = new Captachas(userID);
						break;				
					}
					else{
						messageLabel.setForeground(Color.red);
						messageLabel.setText("Wrong Password");
						break;
					}
				}
				if(userFound == 0){
					messageLabel.setText("User not found");
					messageLabel.setForeground(Color.red);
			}
			}
		}
	}
}
