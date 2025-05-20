import java.util.*;

/**
 * This program demonstrates Set and Map implementations and their operations
 */
public class SetAndMapDemo {
    public static void main(String[] args) {
        // HashSet Demo
        System.out.println("=== HashSet Demo ===");
        HashSet<String> hashSet = new HashSet<>();
        
        // Adding elements
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Mango");
        hashSet.add("Apple"); // Duplicate not allowed
        
        System.out.println("HashSet: " + hashSet);
        System.out.println("Contains 'Apple': " + hashSet.contains("Apple"));
        System.out.println("Size: " + hashSet.size());
        
        // TreeSet Demo
        System.out.println("\n=== TreeSet Demo ===");
        TreeSet<String> treeSet = new TreeSet<>(hashSet);
        
        System.out.println("TreeSet (sorted): " + treeSet);
        System.out.println("First element: " + treeSet.first());
        System.out.println("Last element: " + treeSet.last());
        System.out.println("Subset (Banana to Mango): " + treeSet.subSet("Banana", "Mango"));
        
        // HashMap Demo
        System.out.println("\n=== HashMap Demo ===");
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        // Adding key-value pairs
        hashMap.put("Apple", 1);
        hashMap.put("Banana", 2);
        hashMap.put("Orange", 3);
        hashMap.put("Mango", 4);
        
        System.out.println("HashMap: " + hashMap);
        System.out.println("Value for 'Apple': " + hashMap.get("Apple"));
        System.out.println("Contains key 'Banana': " + hashMap.containsKey("Banana"));
        System.out.println("Contains value 3: " + hashMap.containsValue(3));
        
        // TreeMap Demo
        System.out.println("\n=== TreeMap Demo ===");
        TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
        
        System.out.println("TreeMap (sorted by keys): " + treeMap);
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());
        System.out.println("SubMap (Banana to Mango): " + treeMap.subMap("Banana", "Mango"));
        
        // Iterating through Map
        System.out.println("\n=== Map Iteration ===");
        
        // Using entrySet
        System.out.println("Using entrySet:");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        // Using keySet
        System.out.println("\nUsing keySet:");
        for (String key : hashMap.keySet()) {
            System.out.println(key + ": " + hashMap.get(key));
        }
        
        // Using forEach
        System.out.println("\nUsing forEach:");
        hashMap.forEach((key, value) -> System.out.println(key + ": " + value));
        
        // Generic Set and Map Demo
        System.out.println("\n=== Generic Set and Map Demo ===");
        
        // Generic Set
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2); // Duplicate not allowed
        
        System.out.println("Generic Set: " + numbers);
        
        // Generic Map
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("Even", Arrays.asList(2, 4, 6, 8));
        map.put("Odd", Arrays.asList(1, 3, 5, 7));
        
        System.out.println("Generic Map: " + map);
        
        // Using stream with Set
        System.out.println("\nUsing stream with Set:");
        numbers.stream()
               .filter(n -> n > 1)
               .map(n -> n * 2)
               .forEach(System.out::println);
        
        // Using stream with Map
        System.out.println("\nUsing stream with Map:");
        map.entrySet().stream()
           .filter(e -> e.getKey().equals("Even"))
           .flatMap(e -> e.getValue().stream())
           .forEach(System.out::println);
    }
} 