// Abstract class
abstract class Shape {
    protected String color;

    // Constructor
    public Shape(String color) {
        this.color = color;
    }

    // Abstract method
    abstract double calculateArea();
    abstract double calculatePerimeter();

    // Concrete method
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}

// Concrete class 1
class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Concrete class 2
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Main class
public class Abstraction {
    public static void main(String[] args) {
        // Creating objects
        Circle circle = new Circle("Red", 5.0);
        Rectangle rectangle = new Rectangle("Blue", 4.0, 6.0);

        // Demonstrating abstraction
        System.out.println("Circle Details:");
        System.out.println("--------------");
        circle.displayColor();
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());

        System.out.println("\nRectangle Details:");
        System.out.println("-----------------");
        rectangle.displayColor();
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
    }
} 