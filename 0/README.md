# Java Basics - Theory

## Java Installation & Setup

### JDK (Java Development Kit)
- JDK is a software development environment used for developing Java applications
- Contains JRE + development tools (compiler, debugger, etc.)
- Popular versions: OpenJDK, Oracle JDK
- Installation steps:
  1. Download JDK from official website
  2. Set up JAVA_HOME environment variable
  3. Add Java to system PATH

### Popular IDEs
1. **IntelliJ IDEA**
   - Feature-rich IDE with excellent Java support
   - Smart code completion
   - Built-in tools for debugging and testing
   - Community Edition (free) and Ultimate Edition (paid)

2. **VS Code**
   - Lightweight, extensible editor
   - Requires Java extensions
   - Popular extensions: Language Support for Java, Debugger for Java
   - Free and open-source

3. **Eclipse**
   - Open-source IDE
   - Extensive plugin ecosystem
   - Built-in Java development tools
   - Free to use

## How Java Code Compiles and Runs

### JVM (Java Virtual Machine)
- Virtual machine that executes Java bytecode
- Platform-independent execution environment
- Provides memory management and garbage collection
- Handles security and access control

### JRE (Java Runtime Environment)
- Contains JVM + libraries needed to run Java applications
- Required to run Java programs
- Does not include development tools

### JDK (Java Development Kit)
- Complete development environment
- Includes JRE + development tools
- Required for developing Java applications

### Compilation Process
1. Java source code (.java files) is written
2. Java compiler (javac) converts source code to bytecode (.class files)
3. JVM interprets and executes the bytecode
4. Just-In-Time (JIT) compiler optimizes frequently used code

## Comments & Naming Conventions

### Comments
1. **Single-line comments**
   ```java
   // This is a single-line comment
   ```

2. **Multi-line comments**
   ```java
   /* This is a
      multi-line comment */
   ```

3. **Documentation comments**
   ```java
   /** This is a documentation comment
    *  Used for generating JavaDoc
    */
   ```

### Naming Conventions
1. **Classes**: PascalCase (e.g., `StudentRecord`)
2. **Methods/Variables**: camelCase (e.g., `calculateTotal()`)
3. **Constants**: UPPER_SNAKE_CASE (e.g., `MAX_VALUE`)
4. **Packages**: lowercase (e.g., `com.example.project`)
5. **Interfaces**: PascalCase (e.g., `Runnable`)

## Input/Output in Java

### Output Methods
1. **System.out.println()**
   - Prints line with newline
   - Most common output method

2. **System.out.print()**
   - Prints without newline
   - Useful for formatted output

3. **System.out.printf()**
   - Formatted output
   - Similar to C's printf

### Input Methods
1. **Scanner Class**
   - Most common input method
   - Easy to use
   - Supports various data types
   - Requires `java.util.Scanner`

2. **BufferedReader**
   - More efficient for reading large inputs
   - Faster than Scanner
   - Requires `java.io.BufferedReader`
   - Needs to handle IOException

3. **Console Class**
   - Secure input method
   - Hides password input
   - Requires `java.io.Console`

### Best Practices
- Always close input streams
- Handle exceptions properly
- Use try-with-resources for automatic resource management
- Validate input data
- Use appropriate input method based on requirements 