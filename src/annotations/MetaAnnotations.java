package annotations;

/* Meta-annotations :
- Meta-annotations are annotations used to provide information about other annotations.
*/

import java.lang.annotation.*;

@Documented // makes the annotation appear in generated JavaDoc.
@Inherited // allows a class level annotation to be inherited by the subclasses
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Important{
}

@Important
class Parent{}

// @Important is inherited by the child
class Child extends Parent{}


@Repeatable(Skills.class) // Allows the same annotation (here @Skill) to be applied multiple times to the same element.
// here Skills.class is the container annotation that stores multiple skill annotations.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Skill{
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Skills{ // container annotation for @Skill, it stores an array of Skill annotations.
    Skill[] value();
}

// same annotation multiple times
@Skill("Java")
@Skill("Python")
@Skill("Spring")
class Developer {

}


public class MetaAnnotations {
    static void main(String[] args) {
        boolean inh = Child.class.isAnnotationPresent(Important.class);
        System.out.println("@Important is inherited by child : " + inh); // true

       Skill[] skills = Developer.class.getAnnotationsByType(Skill.class);
        System.out.print("Developer skills are ");
        for(Skill skill : skills){
            System.out.print(skill.value()+" ");
        }
        //Developer skills are Java Python Spring
    }
}