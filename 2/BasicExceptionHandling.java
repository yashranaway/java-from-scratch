import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program demonstrates basic exception handling concepts including:
 * - try-catch-finally
 * - Multi-catch
 * - Checked vs Unchecked exceptions
 */
public class BasicExceptionHandling {
    public static void main(String[] args) {
        // 1. Basic try-catch
        System.out.println("=== Basic try-catch ===");
        try {
            int result = 10 / 0; // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        // 2. Multiple catch blocks
        System.out.println("\n=== Multiple catch blocks ===");
        try {
            String str = null;
            System.out.println(str.length()); // This will throw NullPointerException
            int[] arr = new int[5];
            System.out.println(arr[10]); // This would throw ArrayIndexOutOfBoundsException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // 3. Multi-catch (Java 7+)
        System.out.println("\n=== Multi-catch ===");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // 4. try-catch-finally
        System.out.println("\n=== try-catch-finally ===");
        FileReader reader = null;
        try {
            reader = new FileReader("nonexistent.txt");
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing file: " + e.getMessage());
                }
            }
            System.out.println("Finally block executed");
        }

        // 5. try-with-resources
        System.out.println("\n=== try-with-resources ===");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            System.out.println("You entered: " + number);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 6. Nested try-catch
        System.out.println("\n=== Nested try-catch ===");
        try {
            try {
                int[] arr = new int[5];
                System.out.println(arr[10]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: " + e.getMessage());
                throw e; // Re-throwing the exception
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: " + e.getMessage());
        }
    }
} 