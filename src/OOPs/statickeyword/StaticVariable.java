package OOPs.statickeyword;
class Student{
    int age;
    String name;
    static String school;
    Student(int age, String name){
        this.age = age;
        this.name = name;
        school = "Amity University";
    }
}
public class StaticVariable {
    public static void main(String[] args) {
        Student s = new Student(24, "Navin");
        //System.out.println(s.school); // ❌ not recommended
        System.out.println(Student.school); // We can access using class name

        Student s2 = new Student(23, "Aditi");
        System.out.println(s.school + "   "+s2.school); // same for all the objects of Student class becuase only one copy is created..
    }
}
