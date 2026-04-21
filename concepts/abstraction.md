# Abstraction

Hiding implementation and showing only essential details.

---
## Abstract Class 

```
abstract class A{
    abstract void show(); // abstract method
    void display(){ // concrete method
    }
}
```

- Cannot create object :` new A(); // ❌`
- Can have :
  - Abstract methods
  - Concrete methods
  - Constructors
- If any method is abstract ➡ class must be abstract.

---
## Abstract Method

`abstract void show();`
- No body
- Must be overridden in child class

---
## Constructor in Abstract Class

Allowed ✅
```
A(){
    System.out.println("Constructor");
}
```
Called when child object is created due to super().
- We cannot make constructor as abstract, its illegal.

---
## Importance 

- Use when you want common code + partial abstraction.

---
### Important Points 

- We can declare class as abstract, method as abstract however we cannot have a variable as abstract.
- Abstract class cannot be final because final class do not participate in inheritance and abstract class must participate in inheritance.