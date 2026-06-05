package dsa.collections.queue;

class CircularQueue{ // via circular array
    private int front;
    private int rear;
    private int size;
    private int[] arr;
    CircularQueue(int capacity){
        arr = new int[capacity];
    }
    void add(int val) throws Exception{
        if(size == arr.length) throw new Exception("Queue Overflow");
        arr[rear++] = val;
        if(rear == arr.length) rear = 0;
        size++;
    }
    int remove() throws Exception{
        if(size == 0){
            throw new Exception("Underflow Error");
        }
        int top = arr[front];
        front++;
        if(front == arr.length) front = 0;
        size--;
        return top;
    }
    int peek() throws Exception {
        if (size == 0) {
            throw new Exception("Underflow Error");
        }
        return arr[front];
    }
    boolean isEmpty(){
        return size==0;
    }
    void print(){
        if(size == 0) System.out.println("[]");;
        if(front >= rear){
            for(int i=front; i<arr.length; i++){
                System.out.print(arr[i]+" ");
            }
            for(int i=0; i<rear; i++){
                System.out.print(arr[i]+" ");
            }
        }
        else{
            for(int i=front; i<rear; i++){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
}
public class ImplementationViaCircularArray {
    static void main(String[] args) {
        try{
            CircularQueue q = new CircularQueue(5);
            q.add(10);
            q.add(20);
            q.add(30);
            q.add(40);
            q.print(); // 10 20 30 40
            q.remove();
            System.out.println(q.remove()); // 20
            q.print(); // 30 40
            q.add(50);
            q.add(60);
            q.add(70);
            q.print(); // 30 40 50 60 70
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}