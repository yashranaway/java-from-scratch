/**
 * This class demonstrates Java naming conventions
 * Class names use PascalCase
 */
public class NamingConventionsDemo {
    // Constants use UPPER_SNAKE_CASE
    private static final int MAX_COUNT = 100;
    private static final String DEFAULT_NAME = "Guest";

    // Instance variables use camelCase
    private String firstName;
    private int age;
    private boolean isActive;

    // Constructor uses PascalCase (same as class name)
    public NamingConventionsDemo() {
        this.firstName = DEFAULT_NAME;
        this.age = 0;
        this.isActive = false;
    }

    // Method names use camelCase
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Boolean methods often start with 'is', 'has', or 'can'
    public boolean isActive() {
        return isActive;
    }

    // Method to demonstrate parameter naming (camelCase)
    public void updateUserInfo(String userName, int userAge) {
        this.firstName = userName;
        this.age = userAge;
    }

    // Main method to demonstrate the conventions
    public static void main(String[] args) {
        // Local variables use camelCase
        NamingConventionsDemo demo = new NamingConventionsDemo();
        int currentCount = 0;
        boolean shouldContinue = true;

        // Method calls demonstrate camelCase
        demo.setFirstName("John");
        demo.updateUserInfo("Jane", 25);

        // Constants are accessed using UPPER_SNAKE_CASE
        System.out.println("Maximum count: " + MAX_COUNT);
        System.out.println("Default name: " + DEFAULT_NAME);
    }
} 