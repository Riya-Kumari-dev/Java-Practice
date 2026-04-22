## Interface 

- An interface is used to define requirements of rules of a class.
- Think of it like a **contract** 📜.
- Example : If a class signs the contract(implements the interface), it must follow the rules.
- Before Java 8, through interfaces we can achieve 100% abstraction.
- All methods of an interface are public and abstract implicitly.
```
interface A{
    void show();
}
```
Actually becomes :
```
interface A{
    public abstract void show();
}
```
Java automatically adds public abstract.
- The class implementing the interface must override all methods.
```
interface Animal{
    void sound();
}
class Dog{
    public void sound(){
        System.out.println("Bark");
    }
}
```
- If the class does not override interface methods, it must be abstract.
- We cannot create object of an interface.
```
Animal a = new Animal(); // ❌

Animal a = new Dog(); // ✅
```
This is runtime polymorphism.
- All variables are public static final.
```
interface A{
    int x = 10;
}
```
Actually Java converts it to : `public static final int x = 10;`
So it becomes constant.
- A class can implement multiple interfaces. ✅ Java allows multiple inheritance through interfaces.
- extends keyword must come before implement.
```
class A{}

interface B{}

class C extends A implements B{

}
```
- Interface cannot implement another interface but can extend it.
```
interface A{
    void show();
}
interface B extends A{
    void display();
}
```
- We cannot have constructors in interface.
    - Interfaces do not have objects.
    - Constructor is used for object initialization. So constructor make no sense.
- We can declare normal methods using default keyword. These methods :
    - Have body
    - Are inherited by child classes.
    - Can be overridden.
- We can also have static methods.
    - Static methods cannot be abstract.
    - They must have implementation.
    - Static methods are not inherited.
    - They must be called using interface name.

### Conflict Rule :

If
```
interface A { 
    default void show(){
    }
}
interface B{
    default void show(){
    }
}
class C implements A, B { // ❌ compile time error
}

```
Must override the conflicting default methods.
```
public void show(){
    A.super.show();
}
```

---
## Importance :

Use interface when :
- You want rules / contract.
- You need multiple inheritance.
- You want loose coupling.