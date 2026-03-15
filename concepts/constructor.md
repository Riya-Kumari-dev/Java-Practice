# Constructor

## What Is a Constructor ? 

- A constructor is a special method.
- Name must be as class name.
- Used to initialize instance variables.
- It is automatically called when object is created.
- It does not have any return type (not even void).

---
## Default Constructor 

- If we do not write any constructor, Java compiler automatically creates a default (no argument) constructor.
- We cannot see in code.
- ⭐ If we write any constructor (parameterized or no arg), compiler will not create default constructor.

---
## Parameterized Constructor

- Used to initialize variables with values during object creation.
- If only parameterized constructor exists, we must pass arguments while creating object.
- Otherwise - ❌ compile time error.

---
## Constructor Overloading 

- Multiple constructors in the same class.
- Must have different parameter lists.
- Gives flexibility during object creation.

---
## Constructor and Inheritance

- Constructors cannot be inherited.
- But child constructor can call parent constructor.

---
## super() and this()

### super()

- calls parent class constructor.
- Will be added by java compiler implicitly if not written.
- Must be the first statement.

### this()

- Calls another constructor of the same class.
- Used for constructor chaining.
- Must also be the first statement.

### ⭐ Important 

We cannot use both this() and super() together, because both must be the first line and a constructor can only have one first statement.

### Execution Order 

When child is created : 

- 1️⃣ Parent constructor runs first.
- 2️⃣ Then child constructor runs.
 
Because Java ensures parent part is initialized first.