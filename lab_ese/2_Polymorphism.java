// Base class
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Derived class 1
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }
}

// Derived class 2
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows: Meow! Meow!");
    }
}

// Main class to demonstrate polymorphism
public class Polymorphism {
    public static void main(String[] args) {
        // Creating objects
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();

        // Demonstrating runtime polymorphism
        System.out.println("Demonstrating Polymorphism:");
        System.out.println("------------------------");
        
        animal.makeSound(); // Calls Animal's makeSound
        dog.makeSound();    // Calls Dog's makeSound
        cat.makeSound();    // Calls Cat's makeSound

        // Demonstrating polymorphic array
        System.out.println("\nUsing polymorphic array:");
        System.out.println("------------------------");
        Animal[] animals = new Animal[3];
        animals[0] = new Animal();
        animals[1] = new Dog();
        animals[2] = new Cat();

        for (Animal a : animals) {
            a.makeSound();
        }
    }
} 