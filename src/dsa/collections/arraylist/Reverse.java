package dsa.collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class Reverse {
    static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(14);
        arr.add(34);
        arr.add(40);

        System.out.println(arr);
        Collections.reverse(arr); // reverse the whole arraylist
        System.out.println(arr);

        // khud ka approach
        int i=0;
        int j = arr.size()-1;
        while(i<j){
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
        System.out.println(arr);
    }
}
