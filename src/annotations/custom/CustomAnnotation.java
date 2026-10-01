package annotations.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*@Target -> specifies where the annotation can be used

|   Element Type              |           Can be applied to            |
|-----------------------------|----------------------------------------|
|   TYPE                      |           Class, enum, interface       |
|   METHOD                    |                   method               |
|   FIELD                     |                Field/variable          |
|   CONSTRUCTOR               |               Constructor              |
|   PARAMETER                 |       Method/constructor parameter     |
|  LOCAL_VARIABLE             |              Local Variable            |
|    PACKAGE                  |                 Package                |


@Retention -> specifies how long the annotation information should be retained.
- 3 important retention policies :
1. SOURCE : Only available in the source code.
2. CLASS : The annotation is stored in the .class file, but it is not necessarily available through runtime reflection. (default)
3. RUNTIME : Remains available while the program is running.
*/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface StudentInfo{
    // an annotation can contain elements that allow us to provide metadata when using the annotation.

    String name();
    int age() default 21; // default value of age
}

@StudentInfo(name = "Riya", age = 22) // valid
//@StudentInfo() // not valid
//@StudentInfo(name = "Aditi") // valid
class Student{
    void study(){
        System.out.println("Student is studying");
    }
}
public class CustomAnnotation {
    static void main(String[] args) {
        Student student = new Student();
        student.study(); // Student is studying
    }
}