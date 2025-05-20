# Java Multithreading

## 📚 Theory

### Thread Lifecycle
1. **New**
   - Thread is created but not yet started
   - Memory is allocated
   - Thread object is initialized

2. **Runnable**
   - Thread is ready to run
   - Waiting for CPU time
   - Can be in this state multiple times

3. **Running**
   - Thread is executing
   - Has CPU time
   - Only one thread per CPU core

4. **Blocked/Waiting**
   - Thread is waiting for I/O
   - Waiting for another thread
   - Waiting for a lock

5. **Terminated**
   - Thread has completed execution
   - Cannot be restarted
   - Resources are released

### Runnable vs Thread
1. **Runnable Interface**
   - Functional interface
   - Single method: `run()`
   - Better for extending other classes
   - More flexible
   - Preferred approach

2. **Thread Class**
   - Extends Runnable
   - Additional thread control methods
   - Direct thread manipulation
   - Less flexible
   - Used when specific thread behavior needed

### Thread Priority
1. **Priority Levels**
   - MIN_PRIORITY (1)
   - NORM_PRIORITY (5)
   - MAX_PRIORITY (10)

2. **Priority Management**
   - Set using `setPriority()`
   - Get using `getPriority()`
   - Platform dependent
   - Not guaranteed

### Synchronization
1. **Synchronized Methods**
   - Method level synchronization
   - Object level lock
   - Thread safety
   - Mutual exclusion

2. **Synchronized Blocks**
   - Block level synchronization
   - More granular control
   - Better performance
   - Specific object lock

3. **Volatile Keyword**
   - Variable visibility
   - Memory consistency
   - No atomicity guarantee
   - Used for flags

4. **Atomic Classes**
   - Atomic operations
   - Thread-safe variables
   - No synchronization needed
   - Better performance

### Inter-thread Communication
1. **wait() and notify()**
   - Object class methods
   - Thread coordination
   - Must be in synchronized block
   - Spurious wakeups

2. **notifyAll()**
   - Wake all waiting threads
   - Used when multiple threads waiting
   - More overhead
   - Better for fairness

3. **join()**
   - Wait for thread completion
   - Thread synchronization
   - Timeout option
   - InterruptedException

4. **Thread States**
   - WAITING
   - TIMED_WAITING
   - BLOCKED
   - RUNNABLE

### Best Practices
1. **Thread Safety**
   - Use immutable objects
   - Synchronize properly
   - Avoid deadlocks
   - Use thread-safe collections

2. **Performance**
   - Minimize synchronization
   - Use thread pools
   - Avoid thread creation
   - Consider parallel streams

3. **Debugging**
   - Use thread dumps
   - Monitor thread states
   - Check for deadlocks
   - Profile thread usage

4. **Common Issues**
   - Race conditions
   - Deadlocks
   - Starvation
   - Livelocks
