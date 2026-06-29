package dsa.collections.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(max.isEmpty() && min.isEmpty()) max.add(num);
        else{
            if(max.peek() < num) min.add(num);
            else max.add(num);
        }
        if(Math.abs(max.size() - min.size()) > 1){
            if(max.size() > min.size()) min.add(max.remove());
            else max.add(min.remove());
        }
    }

    public double findMedian() {
        if(max.size() == min.size()) return (max.peek() + min.peek())/2.0;
        else{
            if(max.size()> min.size()) return max.peek();
            else return min.peek();
        }
    }
}
