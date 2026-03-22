package OOPs.statickeyword;

class Student1{
    int age;
    String name;
    static String school;
    static void display(){
        //System.out.println(age + "  "); cannot access instance variable directly as it needs object
        System.out.println(school);
    }
}
public class StaticMethod {
    public static void main(String[] args) {
        Student1.display();
    }
}
