/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bankmanagementsystem";
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "satyam"; // Replace with your MySQL password

    public static void saveToDatabase(
            String name, String father_name, String dob, String gender,
            String email, String marital_status, String address, String city,
            String state, String pin_code) {

        String insertQuery = "INSERT INTO personal_details (name, father_name, dob, gender, email, "
                           + "marital_status, address, city, state, pin_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Set parameters
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, father_name);
            preparedStatement.setString(3, dob);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, email);
            preparedStatement.setString(6, marital_status);
            preparedStatement.setString(7, address);
            preparedStatement.setString(8, city);
            preparedStatement.setString(9, state);
            preparedStatement.setString(10, pin_code);

            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

