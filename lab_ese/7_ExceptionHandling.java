public class ExceptionHandling {
    // Method demonstrating basic try-catch
    public static void basicTryCatch() {
        try {
            int result = 10 / 0; // This will cause ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Basic Try-Catch: " + e.getMessage());
        }
    }

    // Method demonstrating multiple catch blocks
    public static void multipleCatch(String[] args) {
        try {
            int index = Integer.parseInt(args[0]);
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Multiple Catch - Array Index: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Multiple Catch - Number Format: " + e.getMessage());
        }
    }

    // Method demonstrating multi-catch (Java 7+)
    public static void multiCatch(String[] args) {
        try {
            int index = Integer.parseInt(args[0]);
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[index]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Multi-Catch: " + e.getMessage());
        }
    }

    // Method demonstrating try-catch-finally
    public static void tryCatchFinally() {
        try {
            System.out.println("Inside try block");
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Try-Catch-Finally - Exception: " + e.getMessage());
        } finally {
            System.out.println("Try-Catch-Finally - Finally block executed");
        }
    }

    // Method demonstrating nested try-catch
    public static void nestedTryCatch() {
        try {
            try {
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Nested Try-Catch - Inner: " + e.getMessage());
                throw e; // Re-throwing the exception
            }
        } catch (ArithmeticException e) {
            System.out.println("Nested Try-Catch - Outer: " + e.getMessage());
        }
    }

    // Method demonstrating custom exception
    static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    public static void customException() throws CustomException {
        try {
            throw new CustomException("This is a custom exception");
        } catch (CustomException e) {
            System.out.println("Custom Exception: " + e.getMessage());
            throw e; // Re-throwing the custom exception
        }
    }

    public static void main(String[] args) {
        System.out.println("Basic Try-Catch Example:");
        System.out.println("------------------------");
        basicTryCatch();

        System.out.println("\nMultiple Catch Example:");
        System.out.println("----------------------");
        multipleCatch(new String[]{"abc"}); // Will cause NumberFormatException

        System.out.println("\nMulti-Catch Example:");
        System.out.println("-------------------");
        multiCatch(new String[]{"5"}); // Will cause ArrayIndexOutOfBoundsException

        System.out.println("\nTry-Catch-Finally Example:");
        System.out.println("-------------------------");
        tryCatchFinally();

        System.out.println("\nNested Try-Catch Example:");
        System.out.println("------------------------");
        nestedTryCatch();

        System.out.println("\nCustom Exception Example:");
        System.out.println("------------------------");
        try {
            customException();
        } catch (CustomException e) {
            System.out.println("Main method caught: " + e.getMessage());
        }
    }
} 