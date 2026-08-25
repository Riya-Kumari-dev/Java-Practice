package collections.generics;

import java.util.ArrayList;

class Human{
    public Human() {
    }
}
class Student extends Human{
    private int id;
    private String name;
    private int age;

    public Student(int age, int id, String name) {
        this.age = age;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class Employee2{

}
public class WildCards {
    static void main(String[] args) {
        // unbounded wildcard
        ArrayList<?> l = new ArrayList<>();  // don't know the actual type
        // l.add(10); // ❌ cannot add
        // Object x = l.get(0); // ✅ read as object

        ArrayList<Student> arr = new ArrayList<>();
        l = arr;


        // UpperBounded Wildcard
        // of Human or child class of Human
        ArrayList<? extends Human> h = new ArrayList<>();
        // h.add(new Student(23, 1, "Riya")); // ❌ writing not safe

        // Human h2 = h.get(0); // ✅ read as parent
        // Student s = h.get(0); // ❌

        ArrayList<Student> slist = new ArrayList<>();
        ArrayList<Employee2> emp = new ArrayList<>();
        h = slist;
        // h = emp; // ❌ only human or child of human


        // LowerBounded Wildcard
        // Student or any parent class of Student
        ArrayList<? super Student> s = new ArrayList<>();

        s.add(new Student(23, 1, "Riya")); // ✅ writing safe
        // Student s2 = s.get(0); // ❌ reading not safe
        // Human h3 = s.get(0);  // ❌
        Object o = s.get(0); // ✅ read only as Object

        ArrayList<Human> hlist = new ArrayList<>();
        ArrayList<Employee2> em = new ArrayList<>();
        s = hlist;
        // em = hlist; ❌
    }
}