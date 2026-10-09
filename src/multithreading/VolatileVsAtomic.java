package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

class VisitorCounter {
    // volatile ensures that changes to this variable are visible to other threads.
     // However, volatile does NOT make count++ atomic.
    private volatile int count = 0;

    // AtomicInteger supports atomic operations on the counter.
    private final AtomicInteger atomicCount = new AtomicInteger(0);

    // Multiple threads can lose updates when using count++.
    public void incrementVolatile() {
        count++;
    }

    // incrementAndGet() atomically increments the value by 1.
    public void incrementAtomic() {
        atomicCount.incrementAndGet();
    }

    public int getVolatileCount() {
        return count;
    }

    public int getAtomicCount() {
        return atomicCount.get();
    }
}

public class VolatileVsAtomic {
    static void main(String[] args) throws InterruptedException {
        VisitorCounter counter = new VisitorCounter();

        // Each thread records 10,000 visits.
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.incrementVolatile();
                counter.incrementAtomic();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        // Wait until both threads finish updating the counters.
        t1.join();
        t2.join();

        System.out.println("Expected count: 20000");
        System.out.println("Atomic counter: " + counter.getAtomicCount()); // 20000

        System.out.println("Volatile counter: " + counter.getVolatileCount());
        // But the volatile counter may be less than 20000 because both threads can read the same old value and overwrite each other's increments.
        //The exact volatile result is unpredictable.

    }
}