package LoginAuthentication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GussingGameGUI extends JFrame {
    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;
    private int secretNumber;
    private int attempts;
    private final int maxAttempts = 5;

    public GussingGameGUI() {
        setVisible(true);
        setTitle("Guessing Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        JLabel titleLabel = new JLabel("Guess the Number (1-100)");
        titleLabel.setFont(new Font(null, Font.BOLD, 18));
        add(titleLabel);

        guessField = new JTextField();
        add(guessField);
        
        guessButton = new JButton("Guess");
        guessButton.setBackground(Color.yellow);
        guessButton.addActionListener(new GuessButtonListener());
        guessButton.setFocusable(false);
      //  add(new JLabel());
        add(new JLabel());
        add(guessButton);

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font(null, Font.BOLD, 18));
        add(resultLabel);

        generateSecretNumber();
    }

    private void generateSecretNumber() {
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;
        attempts = 0;
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (attempts >= maxAttempts) {
            	resultLabel.setForeground(Color.magenta);
                resultLabel.setText("Sorry, you've used all your attempts.");
                return;
            }

            String guessText = guessField.getText();
            try {
                int guess = Integer.parseInt(guessText);
                attempts++;

                if (guess < secretNumber) {
                	resultLabel.setForeground(Color.red);
                    resultLabel.setText("Too low! Try again.");
                } else if (guess > secretNumber) {
                	resultLabel.setForeground(Color.red);
                    resultLabel.setText("Too high! Try again.");
                } else {
                	resultLabel.setForeground(Color.BLACK);
                    resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                    generateSecretNumber();
                }
            } catch (NumberFormatException ex) {
            	resultLabel.setForeground(Color.red);
                resultLabel.setText("Invalid input. Enter a number.");
            }

            guessField.setText("");
        }
    }
}

