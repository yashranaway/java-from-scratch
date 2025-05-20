import java.util.concurrent.atomic.AtomicInteger;

/**
 * This program demonstrates synchronization and inter-thread communication
 */
public class SynchronizationDemo {
    // Shared resource
    private static class Counter {
        private int count = 0;
        private final AtomicInteger atomicCount = new AtomicInteger(0);

        // Synchronized method
        public synchronized void increment() {
            count++;
        }

        // Synchronized block
        public void incrementBlock() {
            synchronized (this) {
                count++;
            }
        }

        // Using AtomicInteger
        public void incrementAtomic() {
            atomicCount.incrementAndGet();
        }

        public synchronized int getCount() {
            return count;
        }

        public int getAtomicCount() {
            return atomicCount.get();
        }
    }

    // Producer-Consumer example
    private static class MessageQueue {
        private String message;
        private boolean empty = true;

        public synchronized String take() {
            while (empty) {
                try {
                    System.out.println("Consumer waiting for message...");
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Consumer interrupted");
                }
            }
            empty = true;
            notifyAll();
            return message;
        }

        public synchronized void put(String message) {
            while (!empty) {
                try {
                    System.out.println("Producer waiting to send message...");
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Producer interrupted");
                }
            }
            empty = false;
            this.message = message;
            notifyAll();
        }
    }

    public static void main(String[] args) {
        // Synchronization Demo
        System.out.println("=== Synchronization Demo ===");
        Counter counter = new Counter();

        // Creating multiple threads to increment counter
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                    counter.incrementBlock();
                    counter.incrementAtomic();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }

        System.out.println("Final count (synchronized method): " + counter.getCount());
        System.out.println("Final count (synchronized block): " + counter.getCount());
        System.out.println("Final count (AtomicInteger): " + counter.getAtomicCount());

        // Producer-Consumer Demo
        System.out.println("\n=== Producer-Consumer Demo ===");
        MessageQueue queue = new MessageQueue();

        // Producer thread
        Thread producer = new Thread(() -> {
            String[] messages = {"Hello", "World", "Java", "Threading", "Done"};
            for (String message : messages) {
                queue.put(message);
                System.out.println("Produced: " + message);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Producer interrupted");
                }
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            String message;
            do {
                message = queue.take();
                System.out.println("Consumed: " + message);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Consumer interrupted");
                }
            } while (!message.equals("Done"));
        });

        producer.start();
        consumer.start();

        // Wait for producer and consumer to finish
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\nProducer-Consumer demo completed");
    }
} 