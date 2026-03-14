package OOPs;

class Student{
    private String name;
    private int id;
    // this keyword refers to  current instance/object.
    // It is used to differentiate instance variable and local variable
    // when they have same name (commonly in setters and constructors)
    public void setName(String name){
        this.name = name; // this keyword is used to assign parameter values to instance variables
    }
    public String getName(){
        return name;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
}
public class ThisKeyword {
    public static void main(String[] args){
        Student s = new Student();
        s.setName("Riya");
        s.setId(1);
        System.out.println("Name : "+s.getName());
        System.out.println("Id : "+s.getId());

        Student s2 = new Student();
        s.setName("Aditi");
        s.setId(2);
        System.out.println("Name : "+s.getName());
        System.out.println("Id : "+s.getId());
    }
}
