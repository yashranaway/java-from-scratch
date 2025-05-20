# Java Collections Framework

## 📚 Theory

### Collections Framework Overview
- A unified architecture for representing and manipulating collections
- Provides interfaces, implementations, and algorithms
- Reduces programming effort and increases performance
- Promotes software reuse and interoperability

### Core Interfaces
1. **Collection Interface**
   - Root interface for all collections
   - Defines basic operations like add, remove, contains
   - Extended by List, Set, and Queue interfaces

2. **List Interface**
   - Ordered collection (sequence)
   - Allows duplicate elements
   - Elements can be accessed by position
   - Common implementations:
     - ArrayList (resizable array)
     - LinkedList (doubly-linked list)
     - Vector (thread-safe, legacy)
     - Stack (LIFO, legacy)

3. **Set Interface**
   - Collection with no duplicate elements
   - Models mathematical set abstraction
   - Common implementations:
     - HashSet (hash table)
     - TreeSet (red-black tree)
     - LinkedHashSet (hash table + linked list)
     - EnumSet (enum-specific)

4. **Map Interface**
   - Maps keys to values
   - No duplicate keys allowed
   - Common implementations:
     - HashMap (hash table)
     - TreeMap (red-black tree)
     - LinkedHashMap (hash table + linked list)
     - Hashtable (thread-safe, legacy)
     - Properties (configuration)

### List Implementations
1. **ArrayList**
   - Resizable array implementation
   - Fast random access
   - Slow insertion/deletion in middle
   - Good for frequent access
   - Not synchronized

2. **LinkedList**
   - Doubly-linked list implementation
   - Fast insertion/deletion
   - Slow random access
   - Good for frequent modifications
   - Implements Queue interface

### Set Implementations
1. **HashSet**
   - Hash table implementation
   - Fast add, remove, contains
   - No ordering guarantee
   - Uses hashCode() and equals()

2. **TreeSet**
   - Red-black tree implementation
   - Elements are sorted
   - Slower than HashSet
   - Uses Comparable or Comparator

### Map Implementations
1. **HashMap**
   - Hash table implementation
   - Fast key-value operations
   - No ordering guarantee
   - Uses hashCode() and equals()

2. **TreeMap**
   - Red-black tree implementation
   - Keys are sorted
   - Slower than HashMap
   - Uses Comparable or Comparator

### Iterators
1. **Iterator Interface**
   - Allows sequential access to elements
   - Methods: hasNext(), next(), remove()
   - Fail-fast behavior
   - Can't modify collection while iterating

2. **ListIterator Interface**
   - Bidirectional iteration
   - Methods: hasPrevious(), previous()
   - Can modify list while iterating
   - Can get element position

### Generics
1. **Generic Classes**
   - Type-safe collections
   - Compile-time type checking
   - Eliminates type casting
   - Example: `ArrayList<String>`

2. **Generic Methods**
   - Type parameters for methods
   - Can be used with non-generic classes
   - Type inference
   - Example: `public <T> void print(T t)`

3. **Bounded Type Parameters**
   - Restrict types that can be used
   - Upper bounds: `<? extends T>`
   - Lower bounds: `<? super T>`
   - Wildcards: `<?>`

### Best Practices
1. **Collection Selection**
   - Use ArrayList for frequent access
   - Use LinkedList for frequent modifications
   - Use HashSet for unique elements
   - Use TreeSet for sorted elements
   - Use HashMap for key-value pairs
   - Use TreeMap for sorted keys

2. **Performance Considerations**
   - Choose appropriate implementation
   - Consider initial capacity
   - Use appropriate load factor
   - Consider thread safety
   - Use generics for type safety

3. **Common Operations**
   - Use contains() before add()
   - Use remove() with iterator
   - Use clear() to remove all elements
   - Use isEmpty() to check emptiness
   - Use size() to get collection size
