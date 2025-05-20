/**
 * This program demonstrates custom exceptions and throw/throws concepts
 */

// Custom checked exception
class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double amount) {
        super("Insufficient funds. Required: " + amount);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

// Custom unchecked exception
class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// Bank account class to demonstrate exception handling
class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method using throws
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            // Using throw for unchecked exception
            throw new InvalidAmountException("Amount must be positive");
        }
        if (amount > balance) {
            // Using throw for checked exception
            throw new InsufficientFundsException(amount);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ", New balance: " + balance);
    }

    // Method using try-catch internally
    public void deposit(double amount) {
        try {
            if (amount <= 0) {
                throw new InvalidAmountException("Deposit amount must be positive");
            }
            balance += amount;
            System.out.println("Deposited: " + amount + ", New balance: " + balance);
        } catch (InvalidAmountException e) {
            System.out.println("Error during deposit: " + e.getMessage());
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Main class to demonstrate custom exceptions
public class CustomExceptions {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000.0);

        // 1. Demonstrating checked exception handling
        System.out.println("=== Checked Exception Handling ===");
        try {
            account.withdraw(1500.0); // This will throw InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InsufficientFundsException: " + e.getMessage());
            System.out.println("Required amount: " + e.getAmount());
        }

        // 2. Demonstrating unchecked exception handling
        System.out.println("\n=== Unchecked Exception Handling ===");
        try {
            account.withdraw(-100.0); // This will throw InvalidAmountException
        } catch (InvalidAmountException e) {
            System.out.println("Caught InvalidAmountException: " + e.getMessage());
        }

        // 3. Demonstrating internal exception handling
        System.out.println("\n=== Internal Exception Handling ===");
        account.deposit(-50.0); // This will be handled internally

        // 4. Demonstrating successful operations
        System.out.println("\n=== Successful Operations ===");
        try {
            account.deposit(500.0);
            account.withdraw(200.0);
        } catch (InsufficientFundsException e) {
            System.out.println("This should not be printed");
        }

        // 5. Demonstrating exception chaining
        System.out.println("\n=== Exception Chaining ===");
        try {
            try {
                account.withdraw(2000.0);
            } catch (InsufficientFundsException e) {
                throw new RuntimeException("Transaction failed", e);
            }
        } catch (RuntimeException e) {
            System.out.println("Caught chained exception: " + e.getMessage());
            System.out.println("Original cause: " + e.getCause().getMessage());
        }
    }
} 