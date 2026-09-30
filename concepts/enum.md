# 📘 Enum

An enum (enumeration) is a special Java type used to represent fixed set of named constants.
```java
enum Status{
    RUNNING, PENDING, FAILED, SUCCESS
}
```
💡 **Purpose** : When the possible values are fixed, an enum provides a type safe way to represent them.

### 📌 Key Characteristics
- Each enum constant is an object of the enum type.
- Enum constants are implicitly `public static final`.
- Every enum implicitly extends `java.lang.Enum`.
- Enums cannot extend another class.
    - Reason : Every enum already implicitly extends `java.lang.Enum` and Java does not support multiple inheritance of classes. Therefore, an enum cannot extend another class.
- Enums constants behave like predefined instances, they are created and controlled by Java.
    - We cannot do : `Status s = new Status();`
    - The purpose of enum is to maintain a fixed set of instances. if arbitrary objects could be created, we could have :
        ```
      RUNNING
      FAILDED
      SUCCESS 
      + 
      another Status object 
      + 
      another Status object```
    - That would defeat the purpose of having a fixed set of enum constants.

## 🏗️ Enum Constructors 

- An enum can have a constructor : 
    - When the enum is initialized, Java creates an instance for each enum constant.
- Enum constructors cannot be used to create enum objects from outside the enum.
    - Java controls the enum instance creation. Therefore, an enum constructor cannot be public or protected. It can be declared private or with no modifier.
- Even if the constructor is private, we cannot explicitly create enum instances.
    - Java itself controls the creation of enum constants.
    - So, `Laptop.DELL` means accessing an existing enum instance. It does not mean ❌ **Create a new object**.

## 🔗 Enum with Interfaces 

- An enum cannot extend another class, but it can implement interfaces. 
    - Java allows a class to implement multiple interfaces.
- Each enum constant can also provide its own implementation of an interface method.

## 🎭 Runtime Polymorphism

An interface reference can hold an enum constant when the enum implements that interface.
```java
Message message = Status.RUNNING;
message.show();
message = Status.FAILED;
```
The appropriate method implementation is selected at runtime. Changing the reference does not create another enum instance.

## ⭐ Important Points 

- Use `==` to compare enum constants.
- An enum can contain abstract methods, provided every constant supplies the required implementation.
- If two implemented interfaces have conflicting default methods, the enum must resolve the conflict.
- Accessing an enum constant does not create another object.
```java
Laptop l1 = Laptop.DELL;
Laptop l2 = Laptop.DELL;
```
- Only one DELL enum instance exists. Both references points to the same enum constant. So accessing the same constant again doesn't invoke the constructor again.
