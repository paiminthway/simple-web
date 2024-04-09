package LoginAuthentication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class Choice implements ActionListener{
	JFrame frame = new JFrame();
	JButton login = new JButton("Login");
	JButton register = new JButton("Register");
	Choice(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		java.awt.Container c = frame.getContentPane();
		c.setBackground(Color.getHSBColor(45, 40, 100)); // Color
		
		frame.setLocationRelativeTo(null);
		JPanel p1 = new JPanel();
		
		JPanel p2 = new JPanel();
		JPanel space = new JPanel();
		space.setBackground(Color.getHSBColor(45, 40, 100));//Color
		
		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.add(login);
		p1.setBackground(Color.getHSBColor(45, 40, 100));//Color
		
		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		p2.add(register);
		p2.setBackground(Color.getHSBColor(45, 40, 100));//Color
		frame.setLayout(new GridLayout(4,1));
		login.addActionListener(this);
		register.addActionListener(this);
		
		login.setBackground(Color.white);
		login.setForeground(Color.black);
		login.setFocusable(false);

		register.setBackground(Color.white);
		register.setForeground(Color.black);
		register.setFocusable(false);
		
		frame.add(space);
		frame.add(p1);
		frame.add(p2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== login){
			frame.dispose();
			IDandPasswords idandPassword = new IDandPasswords();		
			LoginPage loginPage = new LoginPage(idandPassword.getLoginInfo());;
		}
		if(e.getSource()==register){
			frame.dispose();
			Registration registrationForm = new Registration();
		}
		
	}

}
