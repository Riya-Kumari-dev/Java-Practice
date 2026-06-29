package dsa.collections.priorityqueue;

// minHeap can be visualized as a complete binary tree having node's val is less than it's both the children.

class MinHeap{
    int[] arr;
    private int size;

    // left child idx = 2*parentIdx + 1
    // right child idx = 2*parentIdx + 2
    // parent idx = (childIdx - 1) / 2 => child can be left or right

    MinHeap(int capacity){
        arr = new int[capacity];
    }
    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void add(int val) throws Exception{
        if(size == arr.length) throw new Exception("Capacity is full.");
        arr[size] = val;

        // upHeapify
        upHeapify(size);
        size++;
    }

    private void upHeapify(int i) {
        if(i == 0) return;
        int parentIdx = (i-1)/2;
        // swap till the parent becomes the minimum
        if(arr[i] < arr[parentIdx]){
            swap(i, parentIdx);
            // next iteration
            upHeapify(parentIdx);
        }
    }

    int remove() throws Exception{
        if(size == 0){
            throw new Exception("The MinHeap is Empty.");
        }
        int peek = arr[0];
        // first swap the first and last element
        swap(0, size-1);

        size--;
        // downHeapify
        downHeapify(0);
        return peek;
    }

    private void downHeapify(int parentIdx) {
        // find the node with min value among left, right and parent
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2* parentIdx + 2;
        int minIdx = parentIdx;
        if(leftIdx < size && arr[leftIdx] < arr[minIdx]) minIdx = leftIdx;
        if(rightIdx < size && arr[rightIdx] < arr[minIdx]) minIdx = rightIdx;

        if(minIdx == parentIdx) return;
        // swap the parent with min
        swap(parentIdx, minIdx);

        // check for next iteration
        downHeapify(minIdx);

    }

    int peek() throws Exception{
        if(size == 0){
            throw new Exception("The MinHeap is Empty.");
        }
        return arr[0];
    }
    int size(){
        return size;
    }
    boolean isEmpty(){
        return size == 0;
    }
    void display(){
        System.out.print("[");
        for(int i=0; i<size; i++){
            System.out.print(arr[i]);
            if(i< size-1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
public class ImplementMinHeapByArray {
    static void main(String[] args) {
        MinHeap pq = new MinHeap(15);
        try{
            // System.out.println(pq.peek()); //The MinHeap is Empty.
            pq.add(1);
            pq.add(3);
            pq.add(0);
            pq.add(-3);
            System.out.println(pq.peek()); // -3
            System.out.println(pq.isEmpty()); // false
            System.out.println(pq.size()); // 4
            System.out.println(pq.remove()); // -3
            pq.add(23);
            pq.add(21);
            pq.add(4);
            pq.add(-2);
            pq.add(-4);
            pq.display(); // [-4, -2, 0, 3, 21, 4, 1, 23]
            System.out.println(pq.peek()); // -4

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}