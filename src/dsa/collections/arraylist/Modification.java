package dsa.collections.arraylist;

import java.util.ArrayList;

public class Modification {
    static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(22);
        arr.add(34);
        arr.add(12); // simply adding the 12 at last
        System.out.println(arr);
        arr.set(1,20); // 1st index element will change to 20;
        arr.add(1,14); // insert 14 at index 1
        System.out.println(arr);
        arr.remove(3); // 3rd index element will get removed
        System.out.println(arr);
    }
}
