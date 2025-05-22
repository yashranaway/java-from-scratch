import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        // Creating ArrayList
        List<String> fruits = new java.util.ArrayList<>();
        
        // Adding elements
        System.out.println("Adding elements to ArrayList:");
        System.out.println("---------------------------");
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        System.out.println("Initial list: " + fruits);

        // Adding element at specific index
        fruits.add(2, "Grapes");
        System.out.println("\nAfter adding 'Grapes' at index 2: " + fruits);

        // Accessing elements
        System.out.println("\nAccessing elements:");
        System.out.println("------------------");
        System.out.println("Element at index 0: " + fruits.get(0));
        System.out.println("Element at index 3: " + fruits.get(3));

        // Modifying elements
        System.out.println("\nModifying elements:");
        System.out.println("------------------");
        fruits.set(1, "Blueberry");
        System.out.println("After replacing 'Banana' with 'Blueberry': " + fruits);

        // Removing elements
        System.out.println("\nRemoving elements:");
        System.out.println("----------------");
        fruits.remove("Orange");
        System.out.println("After removing 'Orange': " + fruits);
        fruits.remove(0);
        System.out.println("After removing element at index 0: " + fruits);

        // Checking if element exists
        System.out.println("\nChecking elements:");
        System.out.println("----------------");
        System.out.println("Contains 'Mango'? " + fruits.contains("Mango"));
        System.out.println("Contains 'Apple'? " + fruits.contains("Apple"));

        // Size and isEmpty
        System.out.println("\nSize and Empty check:");
        System.out.println("--------------------");
        System.out.println("Size of list: " + fruits.size());
        System.out.println("Is list empty? " + fruits.isEmpty());

        // Iterating using different methods
        System.out.println("\nIterating through ArrayList:");
        System.out.println("--------------------------");
        
        // Using for-each loop
        System.out.println("\nUsing for-each loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Using forEach method (Java 8+)
        System.out.println("\nUsing forEach method:");
        fruits.forEach(System.out::println);

        // Sorting
        System.out.println("\nSorting ArrayList:");
        System.out.println("----------------");
        Collections.sort(fruits);
        System.out.println("Sorted list: " + fruits);

        // Sublist
        System.out.println("\nCreating sublist:");
        System.out.println("----------------");
        List<String> subList = fruits.subList(0, 2);
        System.out.println("Sublist from index 0 to 2: " + subList);

        // Clearing the list
        System.out.println("\nClearing the list:");
        System.out.println("-----------------");
        fruits.clear();
        System.out.println("After clearing: " + fruits);
        System.out.println("Is list empty? " + fruits.isEmpty());

        // Creating ArrayList with custom objects
        System.out.println("\nWorking with custom objects:");
        System.out.println("--------------------------");
        List<Person> people = new java.util.ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 20));

        // Sorting custom objects
        Collections.sort(people);
        System.out.println("Sorted people by age: " + people);
    }
}

// Custom class for ArrayList demonstration
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }
} 