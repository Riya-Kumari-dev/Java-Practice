package multithreading;

public class ThreadPriority {
    static void main(String[] args) {
        Thread low = new Thread(() ->
            System.out.println(Thread.currentThread().getName() + " Priority: " + Thread.currentThread().getPriority()));

        Thread normal = new Thread(() ->
                System.out.println(Thread.currentThread().getName() + " Priority: " + Thread.currentThread().getPriority()));
        Thread high = new Thread(() ->
                System.out.println(Thread.currentThread().getName() + " Priority: " + Thread.currentThread().getPriority()));

        low.setName("Low");
        normal.setName("Normal");
        high.setName("High");

        // Java provides three commonly used priority constants:
        // MIN_PRIORITY = 1
        // NORM_PRIORITY = 5
        // MAX_PRIORITY = 10

        low.setPriority(Thread.MIN_PRIORITY);
        normal.setPriority(Thread.NORM_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        // getPriority() returns the priority assigned to a thread.
        System.out.println("Low priority: " + low.getPriority());
        System.out.println("Normal priority: " + normal.getPriority());
        System.out.println("High priority: " + high.getPriority());

        System.out.println();
        System.out.println();

        low.start();
        normal.start();
        high.start();

    }
}