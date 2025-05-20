# Exception Handling in Java

## 📚 Theory

### What are Exceptions?
- An exception is an event that occurs during program execution that disrupts the normal flow of instructions
- Exceptions are objects that represent errors or unexpected conditions
- Java provides a robust exception handling mechanism

### Exception Hierarchy
1. **Throwable** (Root class)
   - **Error** (Unchecked)
     - OutOfMemoryError
     - StackOverflowError
     - etc.
   - **Exception** (Checked)
     - **IOException**
     - **SQLException**
   - **RuntimeException** (Unchecked)
     - **NullPointerException**
     - **ArrayIndexOutOfBoundsException**
     - **ArithmeticException**
     - etc.

### Types of Exceptions
1. **Checked Exceptions**
   - Must be handled at compile time
   - Extend Exception class
   - Examples: IOException, SQLException
   - Compiler forces handling

2. **Unchecked Exceptions**
   - Don't need to be handled at compile time
   - Extend RuntimeException
   - Examples: NullPointerException, ArrayIndexOutOfBoundsException
   - Can be handled optionally

### Exception Handling Keywords
1. **try**
   - Block of code to monitor for exceptions
   - Must be followed by catch or finally
   - Can have multiple catch blocks

2. **catch**
   - Handles the exception
   - Can catch specific exceptions
   - Can have multiple catch blocks
   - Order matters (most specific to least specific)

3. **finally**
   - Always executes
   - Used for cleanup code
   - Executes even if exception occurs
   - Executes even if return statement is present

4. **throw**
   - Used to throw an exception explicitly
   - Can throw checked or unchecked exceptions
   - Used within a method

5. **throws**
   - Declares exceptions that a method might throw
   - Used in method signature
   - Required for checked exceptions
   - Can declare multiple exceptions

### Best Practices
1. **Exception Handling**
   - Catch specific exceptions
   - Don't catch Exception class
   - Clean up resources in finally block
   - Use try-with-resources for AutoCloseable resources

2. **Exception Creation**
   - Create meaningful exception messages
   - Include cause in exception
   - Use appropriate exception type
   - Document exceptions in method signature

3. **Resource Management**
   - Use try-with-resources
   - Close resources in finally block
   - Handle multiple resources properly
   - Check for null before closing

### Custom Exceptions
1. **Creating Custom Exceptions**
   - Extend Exception or RuntimeException
   - Provide meaningful constructors
   - Include useful information
   - Follow naming convention (end with 'Exception')

2. **When to Use Custom Exceptions**
   - Business logic exceptions
   - Application-specific errors
   - Better error handling
   - More meaningful error messages

### Multi-catch Blocks
- Introduced in Java 7
- Catch multiple exceptions in one block
- Reduces code duplication
- Makes code more readable
- Example: `catch (IOException | SQLException e)`

### Try-with-resources
- Introduced in Java 7
- Automatically closes resources
- Resources must implement AutoCloseable
- Multiple resources can be declared
- Resources are closed in reverse order

### Exception Chaining
- Preserve the original exception
- Use cause parameter in constructor
- Use initCause() method
- Helps in debugging
- Maintains exception hierarchy
