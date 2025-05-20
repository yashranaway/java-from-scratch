import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class StudentRecordSystem extends JFrame {
    private JTextField nameField, ageField, emailField;
    private JTextArea displayArea;
    private Connection connection;
    
    public StudentRecordSystem() {
        setTitle("Student Record System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Initialize database connection
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:students.db");
            createTables();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
        
        // Create input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        
        inputPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        inputPanel.add(ageField);
        
        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);
        
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(e -> addStudent());
        inputPanel.add(addButton);
        
        // Create display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        
        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Load initial data
        refreshDisplay();
    }
    
    private void createTables() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    age INTEGER,
                    email TEXT UNIQUE
                )
            """);
        }
    }
    
    private void addStudent() {
        try {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String email = emailField.getText();
            
            try (PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO students (name, age, email) VALUES (?, ?, ?)")) {
                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.setString(3, email);
                pstmt.executeUpdate();
                
                // Clear input fields
                nameField.setText("");
                ageField.setText("");
                emailField.setText("");
                
                // Refresh display
                refreshDisplay();
                
                JOptionPane.showMessageDialog(this, "Student added successfully!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void refreshDisplay() {
        try {
            displayArea.setText("");
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
                
                while (rs.next()) {
                    displayArea.append(String.format("ID: %d, Name: %s, Age: %d, Email: %s%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("email")));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentRecordSystem().setVisible(true);
        });
    }
} 