# Java Basics and OOP Concepts

## 🧱 Basics

### Variables & Data Types
- **Primitive Types**:
  - `byte` (8-bit), `short` (16-bit), `int` (32-bit), `long` (64-bit)
  - `float` (32-bit), `double` (64-bit)
  - `char` (16-bit Unicode)
  - `boolean` (true/false)
- **Reference Types**:
  - Objects
  - Arrays
  - Strings

### Keywords
- Access modifiers: `public`, `private`, `protected`, `default`
- Class-related: `class`, `interface`, `extends`, `implements`
- Object-related: `new`, `this`, `super`
- Control flow: `if`, `else`, `switch`, `case`, `default`
- Loops: `for`, `while`, `do`, `break`, `continue`
- Exception handling: `try`, `catch`, `finally`, `throw`, `throws`
- Other: `static`, `final`, `abstract`, `synchronized`, `volatile`

### Typecasting
1. **Implicit Casting** (Widening)
   - Automatic conversion
   - No data loss
   - Example: `int` to `long`

2. **Explicit Casting** (Narrowing)
   - Manual conversion
   - Potential data loss
   - Example: `double` to `int`

### Operators
1. **Arithmetic Operators**
   - `+`, `-`, `*`, `/`, `%`
   - `++`, `--` (increment/decrement)

2. **Relational Operators**
   - `==`, `!=`, `>`, `<`, `>=`, `<=`

3. **Logical Operators**
   - `&&` (AND), `||` (OR), `!` (NOT)

4. **Bitwise Operators**
   - `&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`

### Control Flow
1. **if-else**
   - Simple conditions
   - Nested conditions
   - else-if ladder

2. **switch**
   - Multiple conditions
   - case statements
   - default case
   - break statement

### Loops
1. **for loop**
   - Traditional for loop
   - Enhanced for loop (for-each)

2. **while loop**
   - Pre-test loop
   - Condition check before execution

3. **do-while loop**
   - Post-test loop
   - At least one execution

### Arrays
1. **1D Arrays**
   - Declaration
   - Initialization
   - Accessing elements
   - Array length

2. **2D Arrays**
   - Matrix representation
   - Row and column access
   - Jagged arrays

## 🧱 OOP Concepts

### Classes & Objects
- Class as a blueprint
- Objects as instances
- Instance variables
- Instance methods
- Static members

### Constructors
- Default constructor
- Parameterized constructor
- Constructor overloading
- Constructor chaining

### this and super
- `this` keyword
  - Reference to current object
  - Constructor chaining
  - Method chaining
- `super` keyword
  - Parent class reference
  - Constructor calling
  - Method overriding

### Inheritance
- Single inheritance
- Multi-level inheritance
- Hierarchical inheritance
- Method overriding
- `@Override` annotation

### Polymorphism
1. **Compile-time Polymorphism**
   - Method overloading
   - Operator overloading

2. **Runtime Polymorphism**
   - Method overriding
   - Dynamic method dispatch

### Abstraction
- Abstract classes
- Abstract methods
- Partial implementation
- Cannot be instantiated

### Encapsulation
- Data hiding
- Private fields
- Public methods
- Getters and setters

### Interfaces
- Multiple inheritance
- Abstract methods
- Default methods
- Static methods
- Constants

## 🧱 Core Utilities

### String Handling
- String class
- StringBuffer
- StringBuilder
- String methods
- String immutability

### Wrapper Classes
- Primitive to Object conversion
- Autoboxing
- Unboxing
- Utility methods

### Command Line Args
- `main` method parameters
- Argument parsing
- Array of strings
- Usage examples
