/**
 * EmployeeDatabase_Q26.java
 * 
 * This program demonstrates JDBC connectivity with a database to store and retrieve
 * employee records. It includes a GUI for data entry and display.
 * 
 * Note: This program requires the appropriate JDBC driver for MySQL or PostgreSQL
 * to be in the classpath.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeDatabase_Q26 extends JFrame {
    // JDBC Database URL, Username, and Password
    // Change these values according to your database setup
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    
    // UI Components
    private JTextField nameField;
    private JTextField codeField;
    private JTextField designationField;
    private JTextField salaryField;
    private JButton saveButton;
    private JButton viewButton;
    private JButton clearButton;
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    
    public EmployeeDatabase_Q26() {
        // Set up the frame
        super("Employee Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        
        // Create the main panel with a border layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Create the input form panel
        JPanel formPanel = createFormPanel_Q26();
        mainPanel.add(formPanel, BorderLayout.NORTH);
        
        // Create the table panel
        JPanel tablePanel = createTablePanel_Q26();
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        
        // Set the content pane
        setContentPane(mainPanel);
        
        // Initialize the database
        initializeDatabase_Q26();
    }
    
    private JPanel createFormPanel_Q26() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Employee Information"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Name field
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        nameField = new JTextField(20);
        panel.add(nameField, gbc);
        
        // Code field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        panel.add(new JLabel("Code:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        codeField = new JTextField(10);
        panel.add(codeField, gbc);
        
        // Designation field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        panel.add(new JLabel("Designation:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        designationField = new JTextField(20);
        panel.add(designationField, gbc);
        
        // Salary field
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        panel.add(new JLabel("Salary:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        salaryField = new JTextField(10);
        panel.add(salaryField, gbc);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveEmployee_Q26());
        
        viewButton = new JButton("View All");
        viewButton.addActionListener(e -> viewAllEmployees_Q26());
        
        clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearForm_Q26());
        
        buttonPanel.add(saveButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(clearButton);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        panel.add(buttonPanel, gbc);
        
        return panel;
    }
    
    private JPanel createTablePanel_Q26() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Employee Records"));
        
        // Create the table model with column names
        String[] columnNames = {"Name", "Code", "Designation", "Salary"};
        tableModel = new DefaultTableModel(columnNames, 0);
        
        // Create the table and add it to a scroll pane
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void initializeDatabase_Q26() {
        try (Connection conn = getConnection_Q26()) {
            // Create the employee table if it doesn't exist
            String createTableSQL = 
                "CREATE TABLE IF NOT EXISTS employees (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "code VARCHAR(20) NOT NULL," +
                "designation VARCHAR(100) NOT NULL," +
                "salary DECIMAL(10, 2) NOT NULL)";
            
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
                System.out.println("Database initialized successfully.");
            }
        } catch (SQLException e) {
            showError_Q26("Database Initialization Error", e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void saveEmployee_Q26() {
        // Get the input values
        String name = nameField.getText().trim();
        String code = codeField.getText().trim();
        String designation = designationField.getText().trim();
        String salaryStr = salaryField.getText().trim();
        
        // Validate the input
        if (name.isEmpty() || code.isEmpty() || designation.isEmpty() || salaryStr.isEmpty()) {
            showError_Q26("Input Error", "All fields are required.");
            return;
        }
        
        double salary;
        try {
            salary = Double.parseDouble(salaryStr);
        } catch (NumberFormatException e) {
            showError_Q26("Input Error", "Salary must be a valid number.");
            return;
        }
        
        // Insert the employee record into the database
        try (Connection conn = getConnection_Q26()) {
            String insertSQL = 
                "INSERT INTO employees (name, code, designation, salary) " +
                "VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, name);
                pstmt.setString(2, code);
                pstmt.setString(3, designation);
                pstmt.setDouble(4, salary);
                
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, 
                        "Employee record saved successfully.", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Clear the form and refresh the table
                    clearForm_Q26();
                    viewAllEmployees_Q26();
                }
            }
        } catch (SQLException e) {
            showError_Q26("Database Error", e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void viewAllEmployees_Q26() {
        // Clear the existing table data
        tableModel.setRowCount(0);
        
        // Retrieve all employee records from the database
        try (Connection conn = getConnection_Q26()) {
            String selectSQL = "SELECT name, code, designation, salary FROM employees";
            
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {
                
                // Add each employee record to the table model
                while (rs.next()) {
                    String name = rs.getString("name");
                    String code = rs.getString("code");
                    String designation = rs.getString("designation");
                    double salary = rs.getDouble("salary");
                    
                    Object[] row = {name, code, designation, salary};
                    tableModel.addRow(row);
                }
                
                if (tableModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, 
                        "No employee records found.", 
                        "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException e) {
            showError_Q26("Database Error", e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void clearForm_Q26() {
        nameField.setText("");
        codeField.setText("");
        designationField.setText("");
        salaryField.setText("");
        nameField.requestFocus();
    }
    
    private void showError_Q26(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    private Connection getConnection_Q26() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    public static void main(String[] args) {
        // Load the JDBC driver
        try {
            // For MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // For PostgreSQL
            // Class.forName("org.postgresql.Driver");
            
            // Create and display the GUI on the Event Dispatch Thread
            SwingUtilities.invokeLater(() -> {
                new EmployeeDatabase_Q26().setVisible(true);
            });
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, 
                "JDBC Driver not found. Please add the appropriate JDBC driver to the classpath.", 
                "Driver Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
} 