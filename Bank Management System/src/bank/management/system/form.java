/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class form {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Application Form No. 9341");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);

        // Title label
        JLabel titleLabel = new JLabel("APPLICATION FORM NO. 9341");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBounds(120, 10, 300, 30);
        frame.add(titleLabel);

        // Subtitle label
        JLabel subtitleLabel = new JLabel("Page 1: Personal Details");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setBounds(160, 40, 200, 30);
        frame.add(subtitleLabel);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 80, 100, 25);
        frame.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(180, 80, 250, 25);
        frame.add(nameField);

        // Father's Name
        JLabel fatherNameLabel = new JLabel("Father's Name:");
        fatherNameLabel.setBounds(50, 120, 100, 25);
        frame.add(fatherNameLabel);
        JTextField fatherNameField = new JTextField();
        fatherNameField.setBounds(180, 120, 250, 25);
        frame.add(fatherNameField);

        // Date of Birth
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(50, 160, 100, 25);
        frame.add(dobLabel);
        JTextField dobField = new JTextField();
        dobField.setBounds(180, 160, 250, 25);
        frame.add(dobField);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 200, 100, 25);
        frame.add(genderLabel);
        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setBounds(180, 200, 70, 25);
        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(260, 200, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        frame.add(maleButton);
        frame.add(femaleButton);

        // Email Address
        JLabel emailLabel = new JLabel("Email Address:");
        emailLabel.setBounds(50, 240, 100, 25);
        frame.add(emailLabel);
        JTextField emailField = new JTextField();
        emailField.setBounds(180, 240, 250, 25);
        frame.add(emailField);

        // Marital Status
        JLabel maritalStatusLabel = new JLabel("Marital Status:");
        maritalStatusLabel.setBounds(50, 280, 100, 25);
        frame.add(maritalStatusLabel);
        JRadioButton marriedButton = new JRadioButton("Married");
        marriedButton.setBounds(180, 280, 80, 25);
        JRadioButton unmarriedButton = new JRadioButton("Unmarried");
        unmarriedButton.setBounds(270, 280, 100, 25);
        JRadioButton otherButton = new JRadioButton("Other");
        otherButton.setBounds(380, 280, 80, 25);
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(marriedButton);
        maritalGroup.add(unmarriedButton);
        maritalGroup.add(otherButton);
        frame.add(marriedButton);
        frame.add(unmarriedButton);
        frame.add(otherButton);

        // Address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 320, 100, 25);
        frame.add(addressLabel);
        JTextField addressField = new JTextField();
        addressField.setBounds(180, 320, 250, 25);
        frame.add(addressField);

        // City
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(50, 360, 100, 25);
        frame.add(cityLabel);
        JTextField cityField = new JTextField();
        cityField.setBounds(180, 360, 250, 25);
        frame.add(cityField);

        // State
        JLabel stateLabel = new JLabel("State:");
        stateLabel.setBounds(50, 400, 100, 25);
        frame.add(stateLabel);
        JTextField stateField = new JTextField();
        stateField.setBounds(180, 400, 250, 25);
        frame.add(stateField);

        // Pin Code
        JLabel pinLabel = new JLabel("Pin Code:");
        pinLabel.setBounds(50, 440, 100, 25);
        frame.add(pinLabel);
        JTextField pinField = new JTextField();
        pinField.setBounds(180, 440, 250, 25);
        frame.add(pinField);

        // Next Button
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(200, 500, 100, 30);
        frame.add(nextButton);
        
         nextButton.addActionListener(e -> {
            // Fetch all field values
            String name = nameField.getText();
            String fathersName = fatherNameField.getText();
            String dateOfBirth = dobField.getText();
            String gender = maleButton.isSelected() ? "Male" : "Female";
            String email = emailField.getText();
            String maritalStatus = marriedButton.isSelected() ? "Married" :
                                   unmarriedButton.isSelected() ? "Unmarried" : "Other";
            String address = addressField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            String pinCode = pinField.getText();

            // Call the JDBC method to save the data
            JDBCConnection.saveToDatabase(name, fathersName, dateOfBirth, gender, email,
                                           maritalStatus, address, city, state, pinCode);

            JOptionPane.showMessageDialog(frame, "Details saved successfully!");
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}
