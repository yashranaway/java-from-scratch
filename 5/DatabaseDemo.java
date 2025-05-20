import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This program demonstrates JDBC database operations using SQLite
 */
public class DatabaseDemo {
    // Database connection details
    private static final String DB_URL = "jdbc:sqlite:test.db";
    
    // SQL statements
    private static final String CREATE_TABLE = """
        CREATE TABLE IF NOT EXISTS employees (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            age INTEGER,
            department TEXT,
            salary REAL
        )
    """;
    
    private static final String INSERT_EMPLOYEE = """
        INSERT INTO employees (name, age, department, salary)
        VALUES (?, ?, ?, ?)
    """;
    
    private static final String SELECT_ALL = "SELECT * FROM employees";
    
    private static final String SELECT_BY_DEPARTMENT = """
        SELECT * FROM employees
        WHERE department = ?
    """;
    
    private static final String UPDATE_SALARY = """
        UPDATE employees
        SET salary = ?
        WHERE id = ?
    """;
    
    private static final String DELETE_EMPLOYEE = "DELETE FROM employees WHERE id = ?";
    
    // Employee class to represent database records
    private static class Employee {
        private int id;
        private String name;
        private int age;
        private String department;
        private double salary;
        
        public Employee(String name, int age, String department, double salary) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }
        
        @Override
        public String toString() {
            return String.format("Employee{id=%d, name='%s', age=%d, department='%s', salary=%.2f}",
                    id, name, age, department, salary);
        }
    }
    
    public static void main(String[] args) {
        try {
            // Create database and table
            createDatabase();
            
            // CRUD Operations Demo
            System.out.println("=== CRUD Operations Demo ===");
            
            // Create (Insert) employees
            System.out.println("\nInserting employees...");
            insertEmployee(new Employee("John Doe", 30, "IT", 50000.0));
            insertEmployee(new Employee("Jane Smith", 25, "HR", 45000.0));
            insertEmployee(new Employee("Bob Johnson", 35, "IT", 60000.0));
            
            // Read (Select) all employees
            System.out.println("\nAll employees:");
            List<Employee> allEmployees = getAllEmployees();
            allEmployees.forEach(System.out::println);
            
            // Read employees by department
            System.out.println("\nIT department employees:");
            List<Employee> itEmployees = getEmployeesByDepartment("IT");
            itEmployees.forEach(System.out::println);
            
            // Update employee salary
            System.out.println("\nUpdating John's salary...");
            updateEmployeeSalary(1, 55000.0);
            
            // Verify update
            System.out.println("\nAfter salary update:");
            getAllEmployees().forEach(System.out::println);
            
            // Delete employee
            System.out.println("\nDeleting Jane...");
            deleteEmployee(2);
            
            // Verify deletion
            System.out.println("\nAfter deletion:");
            getAllEmployees().forEach(System.out::println);
            
            // Transaction Demo
            System.out.println("\n=== Transaction Demo ===");
            performTransaction();
            
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void createDatabase() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(CREATE_TABLE);
        }
    }
    
    private static void insertEmployee(Employee employee) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_EMPLOYEE, 
                     Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, employee.name);
            pstmt.setInt(2, employee.age);
            pstmt.setString(3, employee.department);
            pstmt.setDouble(4, employee.salary);
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        employee.id = rs.getInt(1);
                    }
                }
            }
        }
    }
    
    private static List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL)) {
            
            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("department"),
                    rs.getDouble("salary")
                );
                emp.id = rs.getInt("id");
                employees.add(emp);
            }
        }
        return employees;
    }
    
    private static List<Employee> getEmployeesByDepartment(String department) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_DEPARTMENT)) {
            
            pstmt.setString(1, department);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Employee emp = new Employee(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                    );
                    emp.id = rs.getInt("id");
                    employees.add(emp);
                }
            }
        }
        return employees;
    }
    
    private static void updateEmployeeSalary(int id, double newSalary) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_SALARY)) {
            
            pstmt.setDouble(1, newSalary);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }
    
    private static void deleteEmployee(int id) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(DELETE_EMPLOYEE)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
    
    private static void performTransaction() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            // Disable auto-commit
            conn.setAutoCommit(false);
            
            try {
                // Perform multiple operations
                insertEmployee(new Employee("Alice Brown", 28, "Finance", 52000.0));
                insertEmployee(new Employee("Charlie Davis", 32, "Finance", 58000.0));
                
                // Update department budget
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute("UPDATE departments SET budget = budget + 100000 WHERE name = 'Finance'");
                }
                
                // If everything is successful, commit the transaction
                conn.commit();
                System.out.println("Transaction committed successfully");
                
            } catch (SQLException e) {
                // If there's an error, rollback the transaction
                conn.rollback();
                System.out.println("Transaction rolled back due to error: " + e.getMessage());
                throw e;
            } finally {
                // Re-enable auto-commit
                conn.setAutoCommit(true);
            }
        }
    }
} 