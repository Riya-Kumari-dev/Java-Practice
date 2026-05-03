package dsa.collections.arraylist;

import java.util.ArrayList;

public class Display {
    static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(); // array list of size 0
        arr.add(20);
        arr.add(30);
        arr.add(40);
        arr.add(50);

        // ours printing
        for(int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        // built in printing with commas
        System.out.println(arr);

    }
}
