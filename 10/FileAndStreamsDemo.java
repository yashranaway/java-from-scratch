import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class FileAndStreamsDemo {
    // Enum for file types
    enum FileType {
        TEXT(".txt"),
        JSON(".json"),
        CSV(".csv");
        
        private final String extension;
        
        FileType(String extension) {
            this.extension = extension;
        }
        
        public String getExtension() {
            return extension;
        }
    }
    
    public static void main(String[] args) {
        // Create a directory for our files
        Path dir = Paths.get("demo_files");
        try {
            Files.createDirectories(dir);
            
            // Demonstrate file operations
            demonstrateFileOperations(dir);
            
            // Demonstrate streams
            demonstrateStreams();
            
            // Demonstrate lambda expressions
            demonstrateLambdas();
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private static void demonstrateFileOperations(Path dir) throws IOException {
        System.out.println("\n=== File Operations Demo ===");
        
        // Create and write to files using different methods
        for (FileType type : FileType.values()) {
            Path file = dir.resolve("sample" + type.getExtension());
            
            // Using traditional IO
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.toFile()))) {
                writer.write("This is a sample " + type.name().toLowerCase() + " file.");
            }
            
            // Using NIO.2
            List<String> lines = Arrays.asList(
                "Line 1",
                "Line 2",
                "Line 3"
            );
            Files.write(file, lines, StandardOpenOption.APPEND);
            
            // Read file content
            System.out.println("\nContent of " + file.getFileName() + ":");
            Files.lines(file).forEach(System.out::println);
        }
        
        // List all files in directory
        System.out.println("\nFiles in directory:");
        Files.list(dir)
            .map(Path::getFileName)
            .forEach(System.out::println);
    }
    
    private static void demonstrateStreams() {
        System.out.println("\n=== Streams API Demo ===");
        
        // Create a list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filter even numbers and calculate their squares
        List<Integer> evenSquares = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .collect(Collectors.toList());
        
        System.out.println("Even squares: " + evenSquares);
        
        // Calculate sum of all numbers
        int sum = numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
        
        System.out.println("Sum of all numbers: " + sum);
        
        // Group numbers by even/odd
        Map<Boolean, List<Integer>> groupedNumbers = numbers.stream()
            .collect(Collectors.groupingBy(n -> n % 2 == 0));
        
        System.out.println("Grouped numbers: " + groupedNumbers);
    }
    
    private static void demonstrateLambdas() {
        System.out.println("\n=== Lambda Expressions Demo ===");
        
        // Function interface
        Function<String, Integer> stringLength = String::length;
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        
        // Predicate interface
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        
        // Consumer interface
        Consumer<String> printer = System.out::println;
        printer.accept("This is printed using a consumer");
        
        // Supplier interface
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random number: " + randomSupplier.get());
        
        // Method reference
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(System.out::println);
    }
} 