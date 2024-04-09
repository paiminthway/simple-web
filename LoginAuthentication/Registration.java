package LoginAuthentication;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

import java.io.*;
import java.util.Scanner;

public class Registration implements ActionListener {
    JFrame frame = new JFrame("Registration Page");
    JTextField userIDField = new JTextField(20);
    JPasswordField userPasswordField = new JPasswordField(20);
    JPasswordField confirmPasswordField = new JPasswordField(20);

    // Buttons
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton jBack = new JButton("Back");

    // Labels
    JLabel userIDLabel = new JLabel("Enter new userID:\t");
    JLabel userPasswordLabel = new JLabel("Password:             ");
    JLabel confirmPasswordLabel = new JLabel("Confirm pw:           ");
    JLabel messageLabel = new JLabel();

    public Registration() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,350);

        // Set the layout manager to BorderLayout
        frame.setLayout(new BorderLayout());

        // Create a panel for the center region
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        p1.add(userIDLabel);
        p1.add(userIDField);
        p1.setBackground(Color.getHSBColor(45, 40, 100));
        
        JPanel p2 = new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(userPasswordLabel);
        p2.add(userPasswordField);
        p2.setBackground(Color.getHSBColor(45, 40, 100));
        
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout());
        p3.add(confirmPasswordLabel);
        p3.add(confirmPasswordField); 
        p3.setBackground(Color.getHSBColor(45, 40, 100));
        
        JPanel centerPanel = new JPanel(new FlowLayout(100,100,20)); // 3 rows and 2 columns for center
        centerPanel.add(p1);
        centerPanel.add(p2);
        centerPanel.add(p3);
        centerPanel.setBackground(Color.getHSBColor(45, 40, 100));
        // Create a panel for the south region
        JPanel southPanel = new JPanel(new FlowLayout(0,20,20)); // For buttons
        southPanel.add(new JLabel("                       "));
        southPanel.add(registerButton);
        southPanel.add(resetButton);
        southPanel.add(messageLabel);
        southPanel.setBackground(Color.getHSBColor(45, 40, 100));
        
        centerPanel.add(southPanel);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(jBack, BorderLayout.SOUTH);
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        jBack.addActionListener(this);
        frame.setLocationRelativeTo(null);
    
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == jBack){
			frame.dispose();
			new Choice();
		}
        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPasswordField.setText("");
            confirmPasswordField.setText("");
            messageLabel.setText("");
        } else if (e.getSource() == registerButton) {
            String username = userIDField.getText();
            String password = new String(userPasswordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
                return;
            }
            try (Scanner scanner = new Scanner(new File("C:\\Users\\DELL\\workspace\\Raven\\IDAndPassword.txt"))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split("\\s+");
                    String existingUsername = parts[0];
                    String existingPassword = parts[1];
            
                    if (existingUsername.equals(username)) {
                        JOptionPane.showMessageDialog(null, "Username already exists!");//Important
                        return;
                    }
               }
                FileWriter output = new FileWriter(("C:\\Users\\DELL\\workspace\\Raven\\IDAndPassword.txt"),true); // true = data can be appended
                output.write(username +" "+ password+"\n");
                output.close();
                frame.dispose();
                IDandPasswords idandPassword = new IDandPasswords();		
    			LoginPage loginPage = new LoginPage(idandPassword.getLoginInfo());;
    			scanner.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "File not found!");
                return;
            } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
}
