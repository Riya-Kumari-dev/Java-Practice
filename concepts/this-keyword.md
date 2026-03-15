# this Keyword

##  Meaning Of this ##

- this is a reference variable.
- It refers to current object of the class.
- It is used when we want to access the current object's members.

---
## Use Of this Keyword ##

1️⃣ When instance variable and local variable have the same name, we use this.
``` 
class Student{
    int age;
    void setAge(int age){
        this.age = age;
    }
}
```
- age :- local variable
- this.age :- instance variable

2️⃣ this can call the current class method
```
void display(){
    this.show();
}
```
- Call show method of the current object.

3️⃣ this() - calling Another constructor 

- this() is used for constructor chaining.
```
class Student{
    Student{
        System.out.println("Default Constructor");
    }
    Student(int age){
        this();
        System.out.println("Parameterized Constructor");
    }
}
```
- this() must be the first statement in the constructor.

4️⃣ Passing current object as argument
```
void show(Demo obj){
}
void display(){
    show(this);
}
```
- this is passed as current object.

5️⃣ Returning current object
```
Demo show(){
    return this;
}
```
---
## Why this Cannot Be Used in Static Method ? ##

- this refers to the current object.
- Static method belong to class, not object.
- Static methods can run without creating object.
- So, Static methods cannot access instance variables directly.
- Because instance variables need an object.