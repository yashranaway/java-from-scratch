/**
 * This program demonstrates Object-Oriented Programming concepts in Java
 */

// Abstract class demonstrating abstraction
abstract class Animal {
    // Encapsulation: private fields with public getters/setters
    private String name;
    private int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract method
    public abstract void makeSound();

    // Concrete method
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Interface demonstrating interface concept
interface Swimmer {
    void swim();
}

// Class demonstrating inheritance and polymorphism
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age); // Using super to call parent constructor
        this.breed = breed;
    }

    // Method overriding (Runtime Polymorphism)
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof!");
    }

    // Method overloading (Compile-time Polymorphism)
    public void makeSound(int times) {
        for (int i = 0; i < times; i++) {
            makeSound();
        }
    }
}

// Class demonstrating multiple inheritance through interfaces
class Duck extends Animal implements Swimmer {
    public Duck(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Quack!");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming");
    }
}

// Main class to demonstrate OOP concepts
public class OOPConcepts {
    public static void main(String[] args) {
        System.out.println("=== OOP Concepts Demo ===");

        // Creating objects
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Duck duck = new Duck("Donald", 2);

        // Demonstrating encapsulation
        System.out.println("\n=== Encapsulation ===");
        System.out.println("Dog's name: " + dog.getName());
        System.out.println("Dog's age: " + dog.getAge());
        dog.setAge(4);
        System.out.println("Dog's new age: " + dog.getAge());

        // Demonstrating inheritance
        System.out.println("\n=== Inheritance ===");
        dog.sleep(); // Inherited method
        duck.sleep(); // Inherited method

        // Demonstrating polymorphism
        System.out.println("\n=== Polymorphism ===");
        Animal[] animals = {dog, duck};
        for (Animal animal : animals) {
            animal.makeSound(); // Runtime polymorphism
        }

        // Demonstrating method overloading
        System.out.println("\n=== Method Overloading ===");
        dog.makeSound(); // Single woof
        dog.makeSound(3); // Three woofs

        // Demonstrating interface implementation
        System.out.println("\n=== Interface Implementation ===");
        duck.swim();

        // Demonstrating this and super
        System.out.println("\n=== this and super ===");
        System.out.println("Dog's breed: " + dog.getBreed());
    }
} 