import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * This program demonstrates different ways of handling input and output in Java
 */
public class InputOutputDemo {
    public static void main(String[] args) {
        // 1. Basic output methods
        System.out.println("=== Basic Output Methods ===");
        System.out.println("Using println() - adds new line");
        System.out.print("Using print() - no new line ");
        System.out.println("See?");
        System.out.printf("Using printf() - formatted output: %d + %d = %d%n", 5, 3, 5 + 3);

        // 2. Scanner input
        System.out.println("\n=== Scanner Input ===");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.printf("Hello %s! You are %d years old.%n", name, age);
        
        // 3. BufferedReader input
        System.out.println("\n=== BufferedReader Input ===");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter a message: ");
            String message = reader.readLine();
            System.out.println("You entered: " + message);
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }

        // Close scanner
        scanner.close();
    }
} 