# Method Overloading

## Definition

- Method overloading means multiple methods having the same name but different parameter lists.
- The difference can be in :
-  1️⃣ Number of parameters. 
-  2️⃣ Types of parameters
- 3️⃣ Order of parameters.
- The compiler differentiates methods using method signature.

➡️ **Method Signature = Method name +  Parameter list**

---
## JVM and Overloaded main() Method 

- We can overload the main() method.
- But the JVM always starts execution from
```public static void main(String[] args) ```
- Other overloaded main() methods behave like normal methods.

---
## Same Parameters Are Not Allowed 

If two methods have : 
- 1️⃣ same name
- 2️⃣ same number of parameters
- 3️⃣ same type of parameters
```
add(int a, int b)
add(int x, int y)
```
❌ **Compile time error**

Because they have the same name method signature.

---
## Different Parameter Types Are Allowed

``` 
add(int a, int b)
add(double a, double b)
```
✅ Allowed because parameter types are different.

---
## Swapping Parameter Order 

```
add(int a, double b)
add(double a, int b)
```
This is technically valid overloading because the order of parameters is different.

⭐ But a problem can occur while calling : `add(10, 20)`

Both int values can convert to double, so the compiler may get confused causing ambiguity.

---
## How Compiler Chooses a Method

When calling overloaded methods the compiler prefers :
- 1️⃣ Exact match
- 2️⃣ Widening conversion (int ➡️ double)
- 3️⃣ Autoboxing
- 4️⃣ Varags

The compiler chooses the safest and most specific match.

---
### Method overloading happens at compile time

The compiler decides which method to call before the program runs. So it is called : 
**Compile time polymorphism , static polymorphism or early binding.**

---
## Why it is Called False Polymorphism

It looks like one method is doing many tasks, but internally they are different methods.

- There is no runtime decision.
- The compiler already knows which method to call.
- So it is called false polymorphism.
