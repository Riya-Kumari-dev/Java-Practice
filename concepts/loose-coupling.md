# Loose Coupling 

- Loose coupling means reducing direct dependency between classes.
- Changes in one class do no affect others.
- Makes code :
  - Flexible
  - Maintainable
  - Scalable

---
## ❓ Problem : Tight Coupling 

- When a class creates its own dependency, it becomes tightly coupled.
```
class Person extends Dominos{
    code here---
}
or
class Person{
    Dominos d = new Dominos();
}
```
- In both the cases Person is directly dependent on Dominos.
- Cannot switch to Swiggy, Zepto or Zomato and others easily.
- Thus, code becomes rigid.

---
## ✅ Solution : Dependency Injection(DI) 

- Dependency Injection = Passing dependencies from outside instead of creating them inside.
- This leads directly to **loose coupling**.

## How DI achieves Loose Coupling

### Using Interfaces

- Depend on abstraction, not implementation.
```
public interface IPizzaProvider{
    void bringPizza();
}
```
- IPizzaProvider instead of Dominos

### Using Injection Methods 💉

#### 1️⃣ Constructor Injection

- Dependency provides at object Creation.
- Ensures dependency is always available.
- Promotes stronger design(preferred).

```
public class Dominos implements IPizzaProvider{
    public void bringPizza(){
        System.out.println("Our Dominos team successfully delivered your pizza. Please Enjoy 😋!");
    }
}
```

```
public static void main(String[] args){
    Person p = new Person(new Dominos());
}
```

#### 2️⃣ Setter Injection

- Dependency provided after object creation.
- Useful for optional dependencies
- Can override constructor injected values
```
p.setPizzaProvider(Zomato);
```

--- 
### Real Life Pizza Analogy 🍕

- You : Target Class(Person)
- Pizza Shops ➡ Dependent classes (Dominos, Zomato)
- Friend ➡ Interface (IPizzaProvider)
- 👉 Instead of calling a specific shop : You can tell your friend : "Get me a pizza from anywhere"
- Here, you don't depend on a specific shop ➡ That's **loose coupling via DI**.