public class Encapsulation {
    // Private fields
    private String name;
    private int age;
    private double salary;
    private String department;

    // Constructor
    public Encapsulation(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name!");
        }
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Invalid age! Age must be between 18 and 65.");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary! Salary cannot be negative.");
        }
    }

    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department;
        } else {
            System.out.println("Invalid department!");
        }
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
    }

    public static void main(String[] args) {
        // Creating an employee object
        Encapsulation employee = new Encapsulation("John Doe", 30, 50000.0, "IT");

        // Displaying initial details
        System.out.println("Initial Details:");
        employee.displayDetails();

        // Demonstrating encapsulation with setters
        System.out.println("\nUpdating Details:");
        System.out.println("----------------");
        
        // Valid updates
        employee.setName("John Smith");
        employee.setAge(35);
        employee.setSalary(60000.0);
        employee.setDepartment("Software Development");

        // Invalid updates
        employee.setName("");  // Invalid name
        employee.setAge(15);   // Invalid age
        employee.setSalary(-1000);  // Invalid salary
        employee.setDepartment("");  // Invalid department

        // Displaying updated details
        System.out.println("\nUpdated Details:");
        employee.displayDetails();
    }
} 