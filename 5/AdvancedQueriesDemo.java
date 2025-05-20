import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This program demonstrates advanced JDBC features including stored procedures and join queries
 */
public class AdvancedQueriesDemo {
    private static final String DB_URL = "jdbc:sqlite:test.db";
    
    // SQL statements for creating tables
    private static final String CREATE_DEPARTMENTS = """
        CREATE TABLE IF NOT EXISTS departments (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            budget REAL,
            location TEXT
        )
    """;
    
    private static final String CREATE_EMPLOYEES = """
        CREATE TABLE IF NOT EXISTS employees (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            age INTEGER,
            department_id INTEGER,
            salary REAL,
            FOREIGN KEY (department_id) REFERENCES departments(id)
        )
    """;
    
    private static final String CREATE_PROJECTS = """
        CREATE TABLE IF NOT EXISTS projects (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            budget REAL,
            start_date TEXT,
            end_date TEXT
        )
    """;
    
    private static final String CREATE_EMPLOYEE_PROJECTS = """
        CREATE TABLE IF NOT EXISTS employee_projects (
            employee_id INTEGER,
            project_id INTEGER,
            hours_worked INTEGER,
            PRIMARY KEY (employee_id, project_id),
            FOREIGN KEY (employee_id) REFERENCES employees(id),
            FOREIGN KEY (project_id) REFERENCES projects(id)
        )
    """;
    
    // Join query to get employee details with department information
    private static final String EMPLOYEE_DEPARTMENT_JOIN = """
        SELECT e.id, e.name, e.age, e.salary, d.name as department_name, d.location
        FROM employees e
        LEFT JOIN departments d ON e.department_id = d.id
        ORDER BY e.id
    """;
    
    // Join query to get project details with employee assignments
    private static final String PROJECT_EMPLOYEE_JOIN = """
        SELECT p.name as project_name, p.budget, e.name as employee_name, ep.hours_worked
        FROM projects p
        LEFT JOIN employee_projects ep ON p.id = ep.project_id
        LEFT JOIN employees e ON ep.employee_id = e.id
        ORDER BY p.name, e.name
    """;
    
    public static void main(String[] args) {
        try {
            // Create database schema
            createDatabaseSchema();
            
            // Insert sample data
            insertSampleData();
            
            // Demonstrate join queries
            System.out.println("=== Join Queries Demo ===");
            
            System.out.println("\nEmployee-Department Join:");
            List<EmployeeDepartment> employeeDepartments = getEmployeeDepartments();
            employeeDepartments.forEach(System.out::println);
            
            System.out.println("\nProject-Employee Join:");
            List<ProjectEmployee> projectEmployees = getProjectEmployees();
            projectEmployees.forEach(System.out::println);
            
            // Demonstrate stored procedure (SQLite doesn't support stored procedures,
            // so we'll simulate it with a transaction)
            System.out.println("\n=== Stored Procedure Demo ===");
            transferEmployee(1, 2); // Transfer employee from department 1 to 2
            
            // Verify the transfer
            System.out.println("\nAfter employee transfer:");
            getEmployeeDepartments().forEach(System.out::println);
            
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void createDatabaseSchema() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            
            stmt.execute(CREATE_DEPARTMENTS);
            stmt.execute(CREATE_EMPLOYEES);
            stmt.execute(CREATE_PROJECTS);
            stmt.execute(CREATE_EMPLOYEE_PROJECTS);
        }
    }
    
    private static void insertSampleData() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            
            // Insert departments
            stmt.execute("INSERT INTO departments (name, budget, location) VALUES " +
                    "('IT', 1000000, 'Floor 1'), " +
                    "('HR', 500000, 'Floor 2'), " +
                    "('Finance', 750000, 'Floor 3')");
            
            // Insert employees
            stmt.execute("INSERT INTO employees (name, age, department_id, salary) VALUES " +
                    "('John Doe', 30, 1, 50000), " +
                    "('Jane Smith', 25, 2, 45000), " +
                    "('Bob Johnson', 35, 1, 60000)");
            
            // Insert projects
            stmt.execute("INSERT INTO projects (name, budget, start_date, end_date) VALUES " +
                    "('Website Redesign', 50000, '2024-01-01', '2024-06-30'), " +
                    "('HR System', 75000, '2024-02-01', '2024-12-31')");
            
            // Insert employee-project assignments
            stmt.execute("INSERT INTO employee_projects (employee_id, project_id, hours_worked) VALUES " +
                    "(1, 1, 100), (1, 2, 50), " +
                    "(2, 2, 75), " +
                    "(3, 1, 150)");
        }
    }
    
    private static List<EmployeeDepartment> getEmployeeDepartments() throws SQLException {
        List<EmployeeDepartment> results = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(EMPLOYEE_DEPARTMENT_JOIN)) {
            
            while (rs.next()) {
                EmployeeDepartment ed = new EmployeeDepartment(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getDouble("salary"),
                    rs.getString("department_name"),
                    rs.getString("location")
                );
                results.add(ed);
            }
        }
        return results;
    }
    
    private static List<ProjectEmployee> getProjectEmployees() throws SQLException {
        List<ProjectEmployee> results = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(PROJECT_EMPLOYEE_JOIN)) {
            
            while (rs.next()) {
                ProjectEmployee pe = new ProjectEmployee(
                    rs.getString("project_name"),
                    rs.getDouble("budget"),
                    rs.getString("employee_name"),
                    rs.getInt("hours_worked")
                );
                results.add(pe);
            }
        }
        return results;
    }
    
    private static void transferEmployee(int employeeId, int newDepartmentId) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            conn.setAutoCommit(false);
            try {
                // Update employee's department
                try (PreparedStatement pstmt = conn.prepareStatement(
                        "UPDATE employees SET department_id = ? WHERE id = ?")) {
                    pstmt.setInt(1, newDepartmentId);
                    pstmt.setInt(2, employeeId);
                    pstmt.executeUpdate();
                }
                
                // Update department budgets (simulating a stored procedure)
                try (Statement stmt = conn.createStatement()) {
                    // Get current department budgets
                    ResultSet rs = stmt.executeQuery(
                        "SELECT department_id, budget FROM employees e " +
                        "JOIN departments d ON e.department_id = d.id " +
                        "WHERE e.id = " + employeeId);
                    
                    if (rs.next()) {
                        int oldDeptId = rs.getInt("department_id");
                        double salary = rs.getDouble("budget");
                        
                        // Update old department budget
                        stmt.execute("UPDATE departments SET budget = budget - " + salary +
                                   " WHERE id = " + oldDeptId);
                        
                        // Update new department budget
                        stmt.execute("UPDATE departments SET budget = budget + " + salary +
                                   " WHERE id = " + newDepartmentId);
                    }
                }
                
                conn.commit();
                System.out.println("Employee transfer completed successfully");
                
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Employee transfer failed: " + e.getMessage());
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
    
    // Data classes for join results
    private static class EmployeeDepartment {
        private final int id;
        private final String name;
        private final int age;
        private final double salary;
        private final String departmentName;
        private final String location;
        
        public EmployeeDepartment(int id, String name, int age, double salary,
                                String departmentName, String location) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.departmentName = departmentName;
            this.location = location;
        }
        
        @Override
        public String toString() {
            return String.format("Employee{id=%d, name='%s', age=%d, salary=%.2f, " +
                    "department='%s', location='%s'}", id, name, age, salary,
                    departmentName, location);
        }
    }
    
    private static class ProjectEmployee {
        private final String projectName;
        private final double budget;
        private final String employeeName;
        private final int hoursWorked;
        
        public ProjectEmployee(String projectName, double budget,
                             String employeeName, int hoursWorked) {
            this.projectName = projectName;
            this.budget = budget;
            this.employeeName = employeeName;
            this.hoursWorked = hoursWorked;
        }
        
        @Override
        public String toString() {
            return String.format("Project{name='%s', budget=%.2f, " +
                    "employee='%s', hours=%d}", projectName, budget,
                    employeeName, hoursWorked);
        }
    }
} 