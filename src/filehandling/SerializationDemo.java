package filehandling;

import java.io.*;

// Serializable is a marker interface; it has no methods to implement.
class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    transient int rollNo; // transient fields are not serialized.

    Student(int id, String name, int rollNo) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {

        Student student = new Student(101, "Riya", 2);

        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.txt"))) {
            out.writeObject(student); // writeObject() serializes an object.
            System.out.println("Object serialized!");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.txt"))) {

            Student s = (Student) in.readObject(); // readObject() deserializes an object and returns Object, so we cast it.

            System.out.println(s.id); // 101
            System.out.println(s.name); // Riya
            System.out.println(s.rollNo); // 0 =>  that it is not serialized

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}