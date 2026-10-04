package multithreading;

// by extending Thread
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread is running by extending Thread class");
    }
}

// by implementing Runnable interface
class MyTask implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread is running by implementing Runnable interface");
    }
}
public class CreatingThread {
    static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // JVM starts a new thread and implicitly call the run method

        MyTask t = new MyTask();
        Thread t2 = new Thread(t);
        t2.start();
    }
}