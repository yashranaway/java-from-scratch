public class MethodOverloading {
    // Method overloading with different number of parameters
    public int add(int a, int b) {
        System.out.println("Adding two integers: " + a + " + " + b);
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println("Adding three integers: " + a + " + " + b + " + " + c);
        return a + b + c;
    }

    // Method overloading with different parameter types
    public double add(double a, double b) {
        System.out.println("Adding two doubles: " + a + " + " + b);
        return a + b;
    }

    public String add(String a, String b) {
        System.out.println("Concatenating two strings: " + a + " + " + b);
        return a + b;
    }

    // Method overloading with different parameter order
    public void display(int id, String name) {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    public void display(String name, int id) {
        System.out.println("Name: " + name + ", ID: " + id);
    }

    // Method overloading with varargs
    public int sum(int... numbers) {
        int total = 0;
        System.out.print("Sum of numbers: ");
        for (int num : numbers) {
            total += num;
            System.out.print(num + " ");
        }
        System.out.println();
        return total;
    }

    public static void main(String[] args) {
        MethodOverloading calculator = new MethodOverloading();

        // Testing different number of parameters
        System.out.println("Different Number of Parameters:");
        System.out.println("-----------------------------");
        System.out.println("Result: " + calculator.add(5, 10));
        System.out.println("Result: " + calculator.add(5, 10, 15));

        // Testing different parameter types
        System.out.println("\nDifferent Parameter Types:");
        System.out.println("-------------------------");
        System.out.println("Result: " + calculator.add(5.5, 10.5));
        System.out.println("Result: " + calculator.add("Hello ", "World"));

        // Testing different parameter order
        System.out.println("\nDifferent Parameter Order:");
        System.out.println("-------------------------");
        calculator.display(1, "John");
        calculator.display("Jane", 2);

        // Testing varargs
        System.out.println("\nVariable Arguments:");
        System.out.println("-----------------");
        System.out.println("Total: " + calculator.sum(1, 2, 3, 4, 5));
        System.out.println("Total: " + calculator.sum(10, 20));
        System.out.println("Total: " + calculator.sum(5));

        // Demonstrating automatic type conversion
        System.out.println("\nAutomatic Type Conversion:");
        System.out.println("------------------------");
        System.out.println("Result: " + calculator.add(5, 10.5)); // int + double
        System.out.println("Result: " + calculator.add(5.5, 10)); // double + int
    }
} 