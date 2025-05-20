import java.util.*;

/**
 * This program demonstrates List implementations (ArrayList and LinkedList)
 * and their common operations
 */
public class ListDemo {
    public static void main(String[] args) {
        // ArrayList Demo
        System.out.println("=== ArrayList Demo ===");
        ArrayList<String> arrayList = new ArrayList<>();
        
        // Adding elements
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");
        arrayList.add("Mango");
        arrayList.add("Banana"); // Duplicate allowed
        
        System.out.println("ArrayList: " + arrayList);
        
        // Accessing elements
        System.out.println("\nAccessing elements:");
        System.out.println("First element: " + arrayList.get(0));
        System.out.println("Last element: " + arrayList.get(arrayList.size() - 1));
        
        // Modifying elements
        arrayList.set(1, "Grapes");
        System.out.println("\nAfter modifying: " + arrayList);
        
        // Removing elements
        arrayList.remove("Banana"); // Removes first occurrence
        System.out.println("After removing 'Banana': " + arrayList);
        
        // Sorting
        Collections.sort(arrayList);
        System.out.println("After sorting: " + arrayList);
        
        // LinkedList Demo
        System.out.println("\n=== LinkedList Demo ===");
        LinkedList<String> linkedList = new LinkedList<>();
        
        // Adding elements
        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");
        linkedList.addFirst("Zero"); // Add at beginning
        linkedList.addLast("Fourth"); // Add at end
        
        System.out.println("LinkedList: " + linkedList);
        
        // Queue operations (LinkedList implements Queue)
        System.out.println("\nQueue operations:");
        System.out.println("First element (peek): " + linkedList.peek());
        System.out.println("First element (element): " + linkedList.element());
        System.out.println("Removed first element (poll): " + linkedList.poll());
        System.out.println("After poll: " + linkedList);
        
        // ListIterator Demo
        System.out.println("\n=== ListIterator Demo ===");
        ListIterator<String> iterator = linkedList.listIterator();
        
        System.out.println("Forward iteration:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        System.out.println("\nBackward iteration:");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        
        // Generic List Demo
        System.out.println("\n=== Generic List Demo ===");
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        // Using forEach with lambda
        System.out.println("Using forEach:");
        numbers.forEach(n -> System.out.println(n * 2));
        
        // Using stream
        System.out.println("\nUsing stream:");
        numbers.stream()
               .filter(n -> n > 15)
               .map(n -> n * 2)
               .forEach(System.out::println);
        
        // Performance comparison
        System.out.println("\n=== Performance Comparison ===");
        int size = 100000;
        
        // ArrayList performance
        long startTime = System.nanoTime();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList2.add(0, i); // Adding at beginning
        }
        long arrayListTime = System.nanoTime() - startTime;
        
        // LinkedList performance
        startTime = System.nanoTime();
        LinkedList<Integer> linkedList2 = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList2.addFirst(i); // Adding at beginning
        }
        long linkedListTime = System.nanoTime() - startTime;
        
        System.out.println("ArrayList time: " + arrayListTime / 1000000 + "ms");
        System.out.println("LinkedList time: " + linkedListTime / 1000000 + "ms");
    }
} 