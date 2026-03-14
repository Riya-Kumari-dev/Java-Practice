package OOPs.basic;

class Student{ // class name starts with capital letter -> convention
    // instance variables (belongs to object)
    String name;
    int id;
    String Dept;
    // all above are instance variables
    /* Instance variables :
     - Declared inside the class
      - Outside methods
      - Each object get its own copy*/
    void studing(){
        String sub = "Java"; // local variable
        /*
        Local variable :
        - declared inside method
        - can be used only inside that method
         */
        System.out.println("Student is studing");
    }
    void playing(){
        System.out.println("Student is playing");
    }
}

public class StudentClass {
    public static void main(String[] args){
        // to use the class variables / methods we first have to create object
        Student st = new Student(); // object created

        st.studing();
        st.playing();
    }

}
