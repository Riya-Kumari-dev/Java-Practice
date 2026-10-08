package multithreading;

public class ThreadLifeCycle {
    static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();

        // Thread object has been created, but start() has not been called yet.
        // Therefore, its state is NEW.
        System.out.println("Before start(): " + thread.getState());

        // RUNNABLE includes both ready to run and currently running according to Java's thread-state model.
        // start() asks the JVM to start a new thread.
        thread.start();
        System.out.println("After start() : "+thread.getState());

        // Wait for the thread to finish so that we can observe its final state.
        thread.join();

        // Once run() has completed, the thread reaches the TERMINATED state.
        System.out.println("After completion: " + thread.getState());
    }
}