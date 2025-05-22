public class Constructors {
    private String name;
    private int age;
    private double salary;

    // Default Constructor
    public Constructors() {
        this.name = "Default";
        this.age = 0;
        this.salary = 0.0;
        System.out.println("Default constructor called");
    }

    // Parameterized Constructor
    public Constructors(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        System.out.println("Parameterized constructor called");
    }

    // Copy Constructor
    public Constructors(Constructors other) {
        this.name = other.name;
        this.age = other.age;
        this.salary = other.salary;
        System.out.println("Copy constructor called");
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        // Using default constructor
        Constructors obj1 = new Constructors();
        System.out.println("Object 1 details:");
        obj1.display();

        // Using parameterized constructor
        Constructors obj2 = new Constructors("John", 25, 50000.0);
        System.out.println("\nObject 2 details:");
        obj2.display();

        // Using copy constructor
        Constructors obj3 = new Constructors(obj2);
        System.out.println("\nObject 3 (copied from Object 2) details:");
        obj3.display();
    }
} 