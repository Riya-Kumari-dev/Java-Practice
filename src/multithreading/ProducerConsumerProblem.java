package multithreading;

class Producer extends Thread{
    Queue q;
    int i=1;
    public Producer(Queue q){
        this.q = q;
    }
    public void run(){
        while(true){
            // continuously produce new data
            q.produce(i++);
        }
    }
}

class Consumer extends Thread{
    Queue q;
    public Consumer(Queue q){
        this.q = q;
    }
    public void run(){
        while(true){
            // // continuously consume available data
            q.consume();
        }
    }
}
class Queue{
    int data;
    boolean flag = false;
    // false -> no data is currently available
    // true -> data is available for the consumer

    /*  Producer enters this method to produce data.
    synchronized ensures that only one thread at a time can execute a synchronized method on the same Queue object. */
    synchronized public void produce(int i) {
        try {
            // If data is already available, the producer must wait until the consumer consumes it.
            while (flag) {
                System.out.println("Producer is in waiting state.");
                wait(); // wait() makes the producer enter WAITING state and releases the Queue object's lock.
            }

            // No data is currently available, so the producer can produce new data.
            data = i;
            System.out.println("I have produced data " + data);
            flag = true; // Mark that data is now available for the consumer.
            notify(); // Wake one thread waiting on this Queue object's monitor.
        } catch (InterruptedException e) {
            // Restore the interrupted status of the thread.
            Thread.currentThread().interrupt();
            System.out.println("Producer was interrupted.");
        }
    }
    synchronized public void consume() {
        try {
            // If no data is available, the consumer must wait for the producer.
            while (!flag) {
                System.out.println("Consumer is in waiting state.");
                // wait() releases the Queue object's lock and puts the consumer into WAITING state.
                wait();
            }

            // Data is available, so consume it.
            System.out.println("I have consumed data " + data);
            flag = false; // Mark that the queue is empty again.
            notify();// Wake the producer waiting for the queue to become empty
        } catch (InterruptedException e) {
            // Restore the interrupted status of the thread.
            Thread.currentThread().interrupt();
            System.out.println("Consumer was interrupted.");
        }
    }
}
public class ProducerConsumerProblem {
    static void main(String[] args) {
        // Both producer and consumer share the same Queue object.
        Queue q = new Queue();
        Producer prod = new Producer(q);
        Consumer cons = new Consumer(q);

        prod.start();
        cons.start();
    }
}