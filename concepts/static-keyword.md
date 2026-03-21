# Static Keyword

## Static Variable

- Belongs to the class, not ❌ object.
- Memory allocated at class loading time on Heap area.
- JVM gives default values.
- Only one copy exists.
- Shared among all objects.
- Best practice : Access using `ClassName.variable`
- Use when you want same data for all objects.

## Static Method

- Belongs to class.
- Can be called using class name.
- ❌ Does not need object.
- Can access only static members directly.
- Cannot access instance variables directly.
- main method is static because JVM calls it using class name. It cannot wait for object creation.

## Static Block

- Executes only once ☝️ .
- Runs when class is loaded.
- Runs before main() method.
- Used for initialization before program starts.
- If multiple static blocks ➡️ execute in top-to-bottom order.

## Instance Initialization Block

- Runs at object creation.
- Executes before constructor.
- Used when same code must run in all the constructors.

## Static Import

- Allows using static members without class name.
- Example : Instead of `Math.sqrt()`, you can write `sqrt()` (after static import).

# Static + Inheritance 

- Static variables are inherited.
  - But still belong to parent class.
- Static methods are inherited.
- Static methods cannot be overridden.
  - Because :
    - Overriding = runtime polymorphism
    - Static methods = compile-time binding
    - They belong to class, not object.
  
### Method Hiding

- When child defines static method, it is called method hiding.
- ❌ Not overriding.
- if : 
```
Parent ref = new Child();
ref.show();
```
Parent's method will execute, because static methods depend on **Reference Type** (compile time).