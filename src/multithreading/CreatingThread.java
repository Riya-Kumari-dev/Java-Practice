package multithreading;

// by extending Thread
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread is running by extending Thread class");
    }
}

// by implementing Runnable interface
class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread is running by implementing Runnable interface");
    }
}
public class CreatingThread {
    static void main(String[] args) {
        // 1. Creating a thread by extending Thread
        MyThread thread1= new MyThread();

        // start() creates a new thread and eventually
        // executes run() on that new thread.
        thread1.start();

        // 2. Creating a thread using Runnable
        MyRunnable task = new MyRunnable();
        // Runnable represents the task.
        // Thread is responsible for executing that task.
        Thread thread2 = new Thread(task);
        thread2.start();

        // 3. run() vs start()
        MyThread thread3 = new MyThread();
        // Calling run() directly is just a normal method call.
        // No new thread is created.
        // Therefore, it executes on the main thread.
        thread3.run();
        // start() creates a separate thread.
        thread3.start();
    }
}