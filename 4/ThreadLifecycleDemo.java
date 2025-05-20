/**
 * This program demonstrates thread lifecycle and basic thread operations
 */
public class ThreadLifecycleDemo {
    public static void main(String[] args) {
        // Creating a thread using Runnable
        System.out.println("=== Thread using Runnable ===");
        Runnable runnable = () -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(1000); // Simulating some work
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " is finished");
        };

        // Thread is in NEW state
        Thread thread1 = new Thread(runnable, "Thread-1");
        System.out.println("Thread-1 state: " + thread1.getState());

        // Thread moves to RUNNABLE state
        thread1.start();
        System.out.println("Thread-1 state after start: " + thread1.getState());

        // Creating a thread by extending Thread class
        System.out.println("\n=== Thread extending Thread class ===");
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println("Thread " + getName() + " is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
                System.out.println("Thread " + getName() + " is finished");
            }
        }

        MyThread thread2 = new MyThread();
        thread2.setName("Thread-2");
        System.out.println("Thread-2 state: " + thread2.getState());
        thread2.start();
        System.out.println("Thread-2 state after start: " + thread2.getState());

        // Demonstrating thread priority
        System.out.println("\n=== Thread Priority Demo ===");
        Thread highPriorityThread = new Thread(runnable, "High-Priority");
        Thread lowPriorityThread = new Thread(runnable, "Low-Priority");

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        System.out.println("High-Priority thread priority: " + highPriorityThread.getPriority());
        System.out.println("Low-Priority thread priority: " + lowPriorityThread.getPriority());

        highPriorityThread.start();
        lowPriorityThread.start();

        // Demonstrating thread joining
        System.out.println("\n=== Thread Join Demo ===");
        Thread thread3 = new Thread(() -> {
            System.out.println("Thread-3 is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread-3 interrupted");
            }
            System.out.println("Thread-3 is finished");
        }, "Thread-3");

        thread3.start();
        try {
            System.out.println("Main thread waiting for Thread-3 to finish");
            thread3.join(); // Main thread waits for thread3 to complete
            System.out.println("Thread-3 has finished, main thread continues");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting");
        }

        // Demonstrating thread interruption
        System.out.println("\n=== Thread Interruption Demo ===");
        Thread thread4 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread-4 is running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread-4 interrupted");
                    Thread.currentThread().interrupt(); // Re-interrupt the thread
                    break;
                }
            }
            System.out.println("Thread-4 is finished");
        }, "Thread-4");

        thread4.start();
        try {
            Thread.sleep(3000); // Let thread4 run for 3 seconds
            thread4.interrupt(); // Interrupt thread4
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            highPriorityThread.join();
            lowPriorityThread.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for other threads");
        }

        System.out.println("\nAll threads have finished");
    }
} 