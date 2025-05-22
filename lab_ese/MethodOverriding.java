// Base class
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    public void move() {
        System.out.println("Animal moves");
    }

    protected void eat() {
        System.out.println("Animal eats");
    }

    // Final method that cannot be overridden
    public final void sleep() {
        System.out.println("Animal sleeps");
    }
}

// Derived class 1
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }

    @Override
    public void move() {
        System.out.println("Dog runs on four legs");
    }

    @Override
    protected void eat() {
        System.out.println("Dog eats dog food");
    }

    // Cannot override sleep() as it's final in parent class
}

// Derived class 2
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat meows: Meow! Meow!");
    }

    @Override
    public void move() {
        System.out.println("Cat walks gracefully");
    }

    @Override
    protected void eat() {
        System.out.println("Cat eats cat food");
    }
}

// Main class
public class MethodOverriding {
    public static void main(String[] args) {
        // Creating objects
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();

        System.out.println("Animal Object:");
        System.out.println("-------------");
        animal.makeSound();
        animal.move();
        animal.eat();
        animal.sleep();

        System.out.println("\nDog Object (through Animal reference):");
        System.out.println("------------------------------------");
        dog.makeSound();  // Calls Dog's makeSound
        dog.move();       // Calls Dog's move
        dog.eat();        // Calls Dog's eat
        dog.sleep();      // Calls Animal's sleep (final method)

        System.out.println("\nCat Object (through Animal reference):");
        System.out.println("------------------------------------");
        cat.makeSound();  // Calls Cat's makeSound
        cat.move();       // Calls Cat's move
        cat.eat();        // Calls Cat's eat
        cat.sleep();      // Calls Animal's sleep (final method)

        // Demonstrating runtime polymorphism
        System.out.println("\nRuntime Polymorphism Example:");
        System.out.println("---------------------------");
        Animal[] animals = {new Animal(), new Dog(), new Cat()};
        for (Animal a : animals) {
            System.out.println("\nAnimal type: " + a.getClass().getSimpleName());
            a.makeSound();
            a.move();
            a.eat();
            a.sleep();
        }
    }
} 