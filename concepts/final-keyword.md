# 📝 Final Keyword 

- In Java, final means :
  - "You cannot change this."
- But what changes depends on where we apply it.

---
## Final Class 

- ❌ Cannot be inherited(extended).
- ❌👩‍👧‍👦 No child class allowed.
- Used to prevent overriding of methods completely.
```
  final class A { }
```
- A final class can have non-final methods.
- A final class cannot have abstract methods.
- A class cannot be both abstract and final(contradiction) because abstract class must get inherited but final can't.

---
## Final Method

- ✅ Can be inherited.
- ❌ Cannot be overridden.
- Used to protect method behaviour.
```
class A{
    final void show(){
    }
}
```
Child class cannot override show().
- Final method can be overloaded.
- Final only blocks overriding not overloading.

---
## Final Variable 

- Cannot be reassigned.
- Acts like a constant.
``` 
 final int x = 10;
 x = 20; // ❌ Error
  ```
for reference variables :
```
  final ArrayList list = new ArrayList<>();
  list.add("Hi"); // ✅ allowed
  list = new ArrayList<>();  // ❌ not allowed 
```
You cannot change reference, but you can change the object content.

---
## Constructor and Final 

- ❌ Constructors cannot be final.
- Because constructors are never inherited and never overridden.
- 🙅‍♂️ So final has no meaning here.

---
## Final Class != Immutable Class

- Final class cannot be extended.
- Immutable class : Object state cannot change after creation.
- ☯️ They are different.

---
###  Why is string Final and Immutable 

- String in Java :
  - Final ➡ to block overriding.
  - Immutable ➡ to protect data.
- 🤔 Reasons :
  - Security
  - String pool safety
  - Thread safety
  - Stable hashcode(for HashMap)
  - Internal Java protection
- Final protects behaviour. Immutable protects state.