# Polymorphism

## Meaning of Polymorphism

- **Poly** = Many
- **Morph** = Forms
- 👉 One reference, many forms
```
Animal a = new Dog();
Animal a2 = new Cat();
```
- One reference type ➡ Animal
- Many object forms ➡ Dog, Cat

---
## Types of Polymorphism

### 1️⃣ Compile-Time Polymorphism

- Also called Method Overloading
- Decided at compile time
- Same method name, different parameters
- ✅ Happens without inheritance

### 2️⃣ Runtime Polymorphism

- Also called Method Overriding
- Requires inheritance
- Decided at runtime
- Uses parent reference for child object
```
Animal a = new Dog();
a.sound();
```
Child method executes (if overridden)

---
## Parent Reference for Child Object

`Animal a = new Dog();`

Why important?
Because :
- Reference type = Parent
- Object type = Child
- Method call decided at runtime
- This is real runtime polymorphism
- If child does not override, parent method runs. Works like normal inheritance.

---
### If Method is Static 

- Static methods cannot be overridden
- It is method hiding
- Decided at compile time
- Depends on reference type, not object type
```
Animal a = new Dog();
a.sound(); // sound is a static method
```
- 👉 Calls Animal method
- No runtime polymorphism

---
### If Method is Final

- Final method cannot be overridden 
- Compile time error
- No runtime polymorphism possible

--- 
### If Method is Private

- Private methods are not inherited
- Cannot override
- No polymorphism

---
### If Class is Final

- Cannot be inherited
- No overriding possible 
- No runtime polymorphism possible
- Real Java example : String (String class is final)
