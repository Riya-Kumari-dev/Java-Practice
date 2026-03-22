# Inheritance 

## 📝 What is Inheritance 

Inheritance is the process where one class acquires the properties and behaviour of another class.
- Achieved using the `extends` keyword
- It promotes an "**IS-A relationship*"
- If a class does not extend anything explicitly ➡️ it implicitly extends `Object` class.

## Type Supported in Java

Java supports Multilevel inheritance

`Grandparent - parent - child`

❌ Java does not support :
- Multiple Inheritance (through classes) because of ambiguity(Diamond problem)
- Cyclic Inheritance ➡️ Parent extending child and child extending parent

## Constructors and Inheritance

- ❌ Constructors are not inherited.
- But they are called using super().
- super() is always the first line of child constructor.
- If not written compiler automatically inserts it.

## 🔒 Private Members

- Private variables and private methods are not inherited
- They dan only be assessed inside the same class.

## Method Overriding 

Child class provides its own implementation of inherited method.
If:
- Inherited and not modified ➡ Inherited method
- Inherited and modified ➡ Overridden Method

#### Rules for Overriding

- Method name must be same.
- Parameters must be same
- Return type must be same (Exception ➡ Covariant return type(child return type allowed))
- Visibility cannot be reduced (You can increase visibility but cannot reduce it)

## Parent Reference and Child Object

`Parent ref = new Child();`

You can access :
- ✅ Overridden methods
- ✅ Inherited methods
- ❌ Specialized methods(child only methods)

To access specialized method ➡ Downcasting required.

## Method Overloading 🆚 Method Overriding

| Feature           | Overloading             | Overriding                 |
|-------------------|-------------------------|----------------------------|
 | Class Location    | Same class              | Parent and child           |
| Method name       | Same                    | Same                       |
| Parameters        | Different               | Same                       |
| Return Type       | Can be same or differnt | Must be same(or covariant) |
| Polymorphism Type | Compile time            | Run time                   |