// Single Inheritance
class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    public void bark() {
        System.out.println(name + " is barking");
    }
}

// MultiLevel Inheritance
class Puppy extends Dog {
    public Puppy(String name) {
        super(name);
    }
    
    public void play() {
        System.out.println(name + " is playing");
    }
}

// Interface for Hybrid Inheritance
interface Trainable {
    void train();
}

// Hybrid Inheritance
class TrainedDog extends Dog implements Trainable {
    public TrainedDog(String name) {
        super(name);
    }
    
    @Override
    public void train() {
        System.out.println(name + " is being trained");
    }
}

// Hierarchical Inheritance
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    public void meow() {
        System.out.println(name + " is meowing");
    }
}

class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }
    
    public void roar() {
        System.out.println(name + " is roaring");
    }
}

// Main class to demonstrate all types of inheritance
public class Inheritance {
    public static void main(String[] args) {
        // Single Inheritance
        System.out.println("Single Inheritance:");
        System.out.println("------------------");
        Dog dog = new Dog("Buddy");
        dog.eat();
        dog.bark();

        // MultiLevel Inheritance
        System.out.println("\nMultiLevel Inheritance:");
        System.out.println("----------------------");
        Puppy puppy = new Puppy("Max");
        puppy.eat();
        puppy.bark();
        puppy.play();

        // Hybrid Inheritance
        System.out.println("\nHybrid Inheritance:");
        System.out.println("------------------");
        TrainedDog trainedDog = new TrainedDog("Rex");
        trainedDog.eat();
        trainedDog.bark();
        trainedDog.train();

        // Hierarchical Inheritance
        System.out.println("\nHierarchical Inheritance:");
        System.out.println("------------------------");
        Cat cat = new Cat("Whiskers");
        Lion lion = new Lion("Simba");
        
        cat.eat();
        cat.meow();
        
        lion.eat();
        lion.roar();
    }
} 