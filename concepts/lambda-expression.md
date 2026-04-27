## Anonymous Inner Class 

- A class without a name
- Created at the time of object creation
- Used to 
    - ✅ Override methods
    - ✅ give quick implementations
```java
A obj = new A(){
    public void show(){
        System.out.println("Anonymous Inner Class");
    }
};
```
- ✅ Can override methods 
- ✅ Can add new methods
- ❌ Cannot access new methods using reference(because reference type is parent)

---
## Type of Interface 

1. Normal Interface
    - Multiple abstract methods
2. Functional Interface(SAM)
    - Only one abstract method
    - Can have default + static methods
3. Marker Interface 
    - No methods(eg. Serializable)

---
## Lambda Expression

- Used to implement functional interface
- Short form of anonymous inner class
```java
B b = ()-> System.out.println("Hello");
```

---
### Why Lambda Only work for Functional Interface

- Lambda has no method name
- Compiler needs exactly one abstract method to map
- ❌ Multiple abstract methods ➡ Ambiguity 
- ✅ One abstract method ➡ works

---
### Default and Static Methods

- Do not affect lambda
- Already implemented so no confusion
- ✅ Lambda only implements SAM

--- 
### Object class Method rule

```java
interface Demo{
    void show();
    String toString();
}
```
- ✅ Still functional interface
- 👉 Because toString() is from Object, so it is **not counted**

---
### Local Variable in Lambda

- ✅ Allowed
- ❗Condition :
    - Must be final or effectively final
```java
int x = 10;
//x = 20; // ❌ makes it invalid
```

---
### this Keyword Difference

- Anonymous Class 
    - this ➡ refers to anonymous class object
- Lambda
    - this ➡ refers to outer class object