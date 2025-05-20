import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentForm extends JFrame {
    private JTextField nameField, ageField, emailField;
    private JComboBox<String> courseCombo;
    private JTextArea addressArea;
    private JCheckBox activeCheck;
    private JRadioButton maleRadio, femaleRadio;
    private ButtonGroup genderGroup;
    
    public StudentForm() {
        setTitle("Student Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create main panel with padding
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Personal Information Panel
        JPanel personalPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        personalPanel.setBorder(BorderFactory.createTitledBorder("Personal Information"));
        
        personalPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        personalPanel.add(nameField);
        
        personalPanel.add(new JLabel("Age:"));
        ageField = new JTextField();
        personalPanel.add(ageField);
        
        personalPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        personalPanel.add(emailField);
        
        personalPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        personalPanel.add(genderPanel);
        
        // Course Selection Panel
        JPanel coursePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        coursePanel.setBorder(BorderFactory.createTitledBorder("Course Selection"));
        
        coursePanel.add(new JLabel("Select Course:"));
        String[] courses = {"Computer Science", "Mathematics", "Physics", "Chemistry", "Biology"};
        courseCombo = new JComboBox<>(courses);
        coursePanel.add(courseCombo);
        
        // Address Panel
        JPanel addressPanel = new JPanel(new BorderLayout());
        addressPanel.setBorder(BorderFactory.createTitledBorder("Address"));
        
        addressArea = new JTextArea(3, 20);
        addressArea.setLineWrap(true);
        addressPanel.add(new JScrollPane(addressArea), BorderLayout.CENTER);
        
        // Status Panel
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.setBorder(BorderFactory.createTitledBorder("Status"));
        
        activeCheck = new JCheckBox("Active Student");
        statusPanel.add(activeCheck);
        
        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");
        
        submitButton.addActionListener(e -> submitForm());
        clearButton.addActionListener(e -> clearForm());
        
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        
        // Add all panels to main panel
        mainPanel.add(personalPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(coursePanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(addressPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(statusPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(buttonPanel);
        
        // Add main panel to frame
        add(mainPanel);
        
        // Set frame properties
        setSize(400, 600);
        setLocationRelativeTo(null);
    }
    
    private void submitForm() {
        // Validate form
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter name");
            return;
        }
        
        try {
            Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid age");
            return;
        }
        
        if (!maleRadio.isSelected() && !femaleRadio.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select gender");
            return;
        }
        
        // Display form data
        StringBuilder message = new StringBuilder();
        message.append("Form Data:\n\n");
        message.append("Name: ").append(nameField.getText()).append("\n");
        message.append("Age: ").append(ageField.getText()).append("\n");
        message.append("Email: ").append(emailField.getText()).append("\n");
        message.append("Gender: ").append(maleRadio.isSelected() ? "Male" : "Female").append("\n");
        message.append("Course: ").append(courseCombo.getSelectedItem()).append("\n");
        message.append("Address: ").append(addressArea.getText()).append("\n");
        message.append("Status: ").append(activeCheck.isSelected() ? "Active" : "Inactive");
        
        JOptionPane.showMessageDialog(this, message.toString());
    }
    
    private void clearForm() {
        nameField.setText("");
        ageField.setText("");
        emailField.setText("");
        genderGroup.clearSelection();
        courseCombo.setSelectedIndex(0);
        addressArea.setText("");
        activeCheck.setSelected(false);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentForm().setVisible(true);
        });
    }
} 