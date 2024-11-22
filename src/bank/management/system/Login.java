/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    public Login() {
        // Set up the JFrame
        setTitle("State Bank of India - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center the window
        setLayout(null); // Use absolute layout for custom positioning

        // Create a background panel with an image
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(null); // Allow absolute positioning
        backgroundPanel.setBounds(0, 0, 500, 400);

        // Heading Panel
        JLabel headingLabel = new JLabel("Welcome to State Bank of India");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setBounds(100, 20, 300, 30);
        backgroundPanel.add(headingLabel);

        // Create a panel for the login form
        JPanel formPanel = new JPanel();
        formPanel.setBounds(125, 70, 250, 250); // Centered on the background
        formPanel.setBackground(new Color(255, 255, 255, 200)); // Semi-transparent background
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add form components
        JLabel cardLabel = new JLabel("Card Number:");
        JTextField cardField = new JTextField();
        JLabel pinLabel = new JLabel("PIN:");
        JPasswordField pinField = new JPasswordField();
        JButton signInButton = new JButton("Sign In");
        JButton clearButton = new JButton("Clear");

        // Style the buttons
        signInButton.setBackground(new Color(46, 139, 87));
        signInButton.setForeground(Color.WHITE);
        signInButton.setFocusPainted(false);
        signInButton.setFont(new Font("Arial", Font.BOLD, 14));

        clearButton.setBackground(new Color(220, 20, 60));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Add Sign Up link
        JLabel signUpLabel = new JLabel("Don't have an account? Sign Up");
        signUpLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        signUpLabel.setForeground(Color.BLUE);
        signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add action listeners for buttons
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardField.getText();
                String pin = new String(pinField.getPassword());
                if (!cardNumber.isEmpty() && !pin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardField.setText("");
                pinField.setText("");
            }
        });

        // Add components to the form panel
        formPanel.add(cardLabel);
        formPanel.add(cardField);
        formPanel.add(pinLabel);
        formPanel.add(pinField);
        formPanel.add(signInButton);
        formPanel.add(clearButton);
        formPanel.add(new JLabel()); // Empty label for spacing
        formPanel.add(signUpLabel);

        // Add the form panel to the background panel
        backgroundPanel.add(formPanel);

        // Add the background panel to the frame
        add(backgroundPanel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}

// Custom JPanel for the background
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel() {
        // Load the background image
        backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}


