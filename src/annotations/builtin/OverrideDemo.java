package annotations.builtin;

/* @Override is a built-in Java annotation.
It tells the compiler :
- This method is intended to override a method from the parent class.
- It helps the compiler detect mistakes in the overriding method such as :
      - wrong method name.
      - wrong parameter list
      - Incorrect method signature.
- Override does not perform overriding.
- Override simply asks the compiler to verify that we are actually overriding a method.*/

class Animal{
    void sound(){
        System.out.println("Animal makes sound.");
    }
}
class Dog extends Animal{
    @Override
    void sound(){
        System.out.println("Dog barks.");
    }
}

public class OverrideDemo {
    static void main(String[] args) {
        Animal animal = new Dog();

        // Runtime Polymorphism :
        // the reference is of Animal, but the actual object is Dog.
        // Therefore, Dog's overridden method is executed at runtime.
        animal.sound(); // Dog barks.
    }
}