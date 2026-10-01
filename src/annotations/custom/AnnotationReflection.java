package annotations.custom;

public class AnnotationReflection {
    static void main(String[] args) {
        // student.class gives us the Class object representing the Student class.
        // The Class object allows us to inspect information about the class at runtime.
        Class<Student> studentClass = Student.class;

        // getAnnotation() -> searches for the specified annotation on the Student class.
        // if the annotation is present and available at runtime, it returns an annotation object.
        StudentInfo info= studentClass.getAnnotation(StudentInfo.class);

        System.out.println("Student name : " + info.name()); // Riya
        System.out.println("Student age : "+info.age()); // 22
    }
}