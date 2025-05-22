// Thread class extending Thread
class CounterThread extends Thread {
    private String threadName;
    private int count;

    public CounterThread(String name) {
        this.threadName = name;
        this.count = 0;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + ": Count = " + count++);
                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted");
        }
    }
}

// Thread class implementing Runnable
class MessagePrinter implements Runnable {
    private String message;
    private int times;

    public MessagePrinter(String message, int times) {
        this.message = message;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(message + " " + (i + 1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("MessagePrinter interrupted");
            }
        }
    }
}

// Synchronized counter class
class SynchronizedCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("Count after increment: " + count);
    }

    public synchronized void decrement() {
        count--;
        System.out.println("Count after decrement: " + count);
    }
}

// Main class
public class Multithreading {
    public static void main(String[] args) {
        // Demonstrating thread creation by extending Thread
        System.out.println("Thread Creation by extending Thread:");
        System.out.println("----------------------------------");
        CounterThread thread1 = new CounterThread("Thread-1");
        CounterThread thread2 = new CounterThread("Thread-2");
        thread1.start();
        thread2.start();

        // Demonstrating thread creation by implementing Runnable
        System.out.println("\nThread Creation by implementing Runnable:");
        System.out.println("----------------------------------------");
        Thread runnableThread1 = new Thread(new MessagePrinter("Hello from Thread", 3));
        Thread runnableThread2 = new Thread(new MessagePrinter("Hi from Thread", 3));
        runnableThread1.start();
        runnableThread2.start();

        // Demonstrating synchronized counter
        System.out.println("\nSynchronized Counter:");
        System.out.println("-------------------");
        SynchronizedCounter counter = new SynchronizedCounter();
        
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.increment();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                counter.decrement();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        incrementThread.start();
        decrementThread.start();

        // Wait for all threads to complete
        try {
            thread1.join();
            thread2.join();
            runnableThread1.join();
            runnableThread2.join();
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\nAll threads completed!");
    }
} 