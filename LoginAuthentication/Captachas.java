package LoginAuthentication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Captachas extends JFrame implements ActionListener{
	JFrame frame = new JFrame();
	static int right = 0;
	static int wrong = 0;
	static int chance = 2;
		JButton[] jb = new JButton[9];
		JPanel jp = new JPanel();
		JLabel jl = new JLabel("Find Green Arrow. You have "+chance+" chances ");
		String userID ="";
		
		Captachas(String userName){
			userID = userName;
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(480,550);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			for(int i=0 ;i<9; i++){
				jb[i] = new JButton();
			}
			//Font font1 = new Font("SansSerif", Font.MONOSPACED,15);
			frame.setLayout(new BorderLayout());
			Font font1 = new Font("SansSerif", Font.BOLD, 20);
		 
			frame.add(jl, BorderLayout.NORTH);
			jl.setFont(font1);
			jl.setHorizontalAlignment(JLabel.CENTER);
			if(true){
				for(int i=0 ; i<9; i++){
					jb[i].setIcon(new ImageIcon("C:\\Users\\DELL\\workspace\\Raven\\src\\LoginAuthentication\\Piano\\p"+(i+1)+".jpg"));
				}
			}
			jp.setLayout(new GridLayout(3,3,0,0));
			for(int i=0; i<9; i++){
				jb[i].addActionListener(this);
				jp.add(jb[i]);
			}
			frame.add(jp, BorderLayout.CENTER);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == jb[3]){
				jl.setText("Nice!");
				jl.setForeground(Color.GREEN);
				jb[3].setIcon(new ImageIcon("C:\\Users\\DELL\\workspace\\Raven\\src\\LoginAuthentication\\Piano\\pp1.gif"));
				right++;
			}
			else if(e.getSource() == jb[4]){
				jl.setText("Good!");
				jl.setForeground(Color.GREEN);
				jb[4].setIcon(new ImageIcon("C:\\Users\\DELL\\workspace\\Raven\\src\\LoginAuthentication\\Piano\\pp2.gif"));
				right++;
			}
			else if(e.getSource() == jb[5]){
				jl.setText("Excellent!");
				jl.setForeground(Color.GREEN);
				jb[5].setIcon(new ImageIcon("C:\\Users\\DELL\\workspace\\Raven\\src\\LoginAuthentication\\Piano\\pp3.gif"));
				right++;
			}
			else{
				wrong++;
				chance--;
				jl.setText("Wrong " + wrong+ " times. You have "+chance+" chances ");
				jl.setForeground(Color.red);
				if(wrong>=2){
					JOptionPane.showMessageDialog(null,"Try another one!");
					frame.dispose();
					new Captachas1(userID);
				}

		}
			if(right == 3){
				frame.dispose();
				WelcomePage welcome=  new WelcomePage(userID); 
			}
}
}