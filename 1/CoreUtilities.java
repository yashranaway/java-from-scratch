/**
 * This program demonstrates core Java utilities including:
 * - String Handling
 * - Wrapper Classes
 * - Command Line Arguments
 */
public class CoreUtilities {
    public static void main(String[] args) {
        // String Handling
        System.out.println("=== String Handling ===");
        
        // String creation and methods
        String str1 = "Hello";
        String str2 = "World";
        String str3 = new String("Hello");
        
        // String concatenation
        String result = str1 + " " + str2;
        System.out.println("Concatenation: " + result);
        
        // String methods
        System.out.println("Length: " + result.length());
        System.out.println("Uppercase: " + result.toUpperCase());
        System.out.println("Lowercase: " + result.toLowerCase());
        System.out.println("Substring: " + result.substring(0, 5));
        System.out.println("Contains 'World': " + result.contains("World"));
        System.out.println("Equals: " + str1.equals(str3));
        System.out.println("== comparison: " + (str1 == str3));
        
        // StringBuffer (mutable)
        System.out.println("\nStringBuffer Demo:");
        StringBuffer buffer = new StringBuffer("Hello");
        buffer.append(" World");
        buffer.insert(5, " Beautiful");
        System.out.println("StringBuffer: " + buffer);
        
        // StringBuilder (mutable, not thread-safe)
        System.out.println("\nStringBuilder Demo:");
        StringBuilder builder = new StringBuilder("Hello");
        builder.append(" World");
        builder.reverse();
        System.out.println("StringBuilder: " + builder);

        // Wrapper Classes
        System.out.println("\n=== Wrapper Classes ===");
        
        // Autoboxing (primitive to wrapper)
        Integer intObj = 100;
        Double doubleObj = 3.14;
        Boolean boolObj = true;
        
        // Unboxing (wrapper to primitive)
        int intValue = intObj;
        double doubleValue = doubleObj;
        boolean boolValue = boolObj;
        
        System.out.println("Integer value: " + intValue);
        System.out.println("Double value: " + doubleValue);
        System.out.println("Boolean value: " + boolValue);
        
        // Wrapper class methods
        System.out.println("\nWrapper Class Methods:");
        System.out.println("Integer.parseInt: " + Integer.parseInt("123"));
        System.out.println("Double.toString: " + Double.toString(3.14));
        System.out.println("Character.isDigit: " + Character.isDigit('5'));
        System.out.println("Boolean.valueOf: " + Boolean.valueOf("true"));

        // Command Line Arguments
        System.out.println("\n=== Command Line Arguments ===");
        if (args.length > 0) {
            System.out.println("Number of arguments: " + args.length);
            System.out.println("Arguments:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("args[" + i + "]: " + args[i]);
            }
        } else {
            System.out.println("No command line arguments provided.");
            System.out.println("Try running with: java CoreUtilities arg1 arg2 arg3");
        }
    }
} 