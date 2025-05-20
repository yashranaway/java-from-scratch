import java.util.*;

/**
 * This program demonstrates Generics and Iterators concepts
 */

// Generic class example
class Box<T> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

// Generic method example
class Utils {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Bounded type parameter example
    public static <T extends Number> double sum(T[] numbers) {
        double sum = 0.0;
        for (T number : numbers) {
            sum += number.doubleValue();
        }
        return sum;
    }
}

// Main class to demonstrate generics and iterators
public class GenericsAndIterators {
    public static void main(String[] args) {
        // Generic Class Demo
        System.out.println("=== Generic Class Demo ===");
        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> intBox = new Box<>(42);
        
        System.out.println("String box content: " + stringBox.getContent());
        System.out.println("Integer box content: " + intBox.getContent());
        
        // Generic Method Demo
        System.out.println("\n=== Generic Method Demo ===");
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Hello", "World"};
        
        System.out.println("Integer array:");
        Utils.printArray(intArray);
        System.out.println("String array:");
        Utils.printArray(stringArray);
        
        // Bounded Type Parameter Demo
        System.out.println("\n=== Bounded Type Parameter Demo ===");
        Double[] doubleArray = {1.1, 2.2, 3.3};
        System.out.println("Sum of numbers: " + Utils.sum(intArray));
        System.out.println("Sum of doubles: " + Utils.sum(doubleArray));
        
        // Iterator Demo
        System.out.println("\n=== Iterator Demo ===");
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        
        // Using Iterator
        System.out.println("Using Iterator:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if (element.equals("Banana")) {
                iterator.remove(); // Safe removal during iteration
            }
        }
        
        System.out.println("List after removal: " + list);
        
        // ListIterator Demo
        System.out.println("\n=== ListIterator Demo ===");
        ListIterator<String> listIterator = list.listIterator();
        
        // Forward iteration
        System.out.println("Forward iteration:");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        
        // Backward iteration
        System.out.println("\nBackward iteration:");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
        
        // Generic Collection with Iterator
        System.out.println("\n=== Generic Collection with Iterator ===");
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        
        // Using forEach with lambda
        System.out.println("Using forEach:");
        numbers.forEach(n -> System.out.println(n * 2));
        
        // Using Iterator with generic type
        System.out.println("\nUsing Iterator:");
        Iterator<Integer> numberIterator = numbers.iterator();
        while (numberIterator.hasNext()) {
            Integer number = numberIterator.next();
            System.out.println(number * 2);
        }
        
        // Wildcard Demo
        System.out.println("\n=== Wildcard Demo ===");
        List<Number> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2.5);
        
        // Upper bounded wildcard
        System.out.println("Upper bounded wildcard:");
        printNumbers(numberList);
        
        // Lower bounded wildcard
        System.out.println("\nLower bounded wildcard:");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        addNumbers(integerList);
        System.out.println("Integer list: " + integerList);
    }
    
    // Upper bounded wildcard
    public static void printNumbers(List<? extends Number> numbers) {
        for (Number number : numbers) {
            System.out.println(number);
        }
    }
    
    // Lower bounded wildcard
    public static void addNumbers(List<? super Integer> numbers) {
        numbers.add(3);
        numbers.add(4);
    }
} 