package collections;

import java.util.ArrayList;
import java.util.Collections;

class Students implements Comparable<Students>{
    int marks;
    String name;

    public Students(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int compareTo(Students other){
        return Integer.compare(this.marks, other.marks);
    }

    @Override
    public String toString() {
        return "Students{" +
                "marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
}
public class ComparableDemo {
    /* Comparable :
    -> used to define the natural ordering of the class.
    * */
    static void main(String[] args) {
        ArrayList<Students> list = new ArrayList<>();
        list.add(new Students("Riya", 98));
        list.add(new Students("Neha", 88));
        list.add(new Students("Sneha", 89));

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}