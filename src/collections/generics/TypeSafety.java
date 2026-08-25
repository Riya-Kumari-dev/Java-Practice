package collections.generics;

import java.util.ArrayList;

class Employee{
    private int age;
    private String name;
    private int id;
    Employee(String name, int id, int age){
        this.name = name;
        this.id = id;
        this.age = age;
    }
    @Override
    public String toString(){
        return "Name : "+name+", Id : "+id+", age : "+age;
    }
}
public class TypeSafety {
    static void main(String[] args) {
        // without generics
        ArrayList arr = new ArrayList();
        arr.add(10);
        arr.add("Riya");
        arr.add(23.3);

        // Integer x = (Integer)arr.get(2); // Class Cast Exception -> no type safety

        // Generics allow us to write type-safe and reusable code that can work with different data types.
        ArrayList<Integer> list = new ArrayList<>(); // Generics work with the reference types
       // ArrayList<int> l = new ArrayList<>(); // not work with the primitive types.
        list.add(10);
        // list.add("Riya"); // ❌ compile time error
        list.add(20);
        list.add(40);
        list.add(34);

        Integer y = list.get(1); // no casting required

        System.out.println(y);
        System.out.println(list);
        System.out.println("...........................");

        ArrayList<Employee> list2 = new ArrayList<>();
        list2.add(new Employee("Riya", 3, 23));
        list2.add(new Employee("Rohit", 1, 27));
        list2.add(new Employee("Aman", 2, 25 ));

        System.out.println(list2);
    }
}