package dsa.collections.arraylist;

import java.util.ArrayList;

public class Declaration {
    static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        System.out.println(al);
        al.addFirst(30);
        System.out.println(al);
        al.addLast("Riya");
        System.out.println(al);
        ArrayList b = new ArrayList();
        b.addAll(al);
        System.out.println(b.containsAll(al));
        System.out.println(b);
    }
}
