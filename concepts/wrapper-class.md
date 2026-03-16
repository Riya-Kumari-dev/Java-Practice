# Wrapper Class

## 🎯 Purpose of Wrapper Class

- Wrapper class allow primitive data types to be used as objects.
- This helps Java behave more like a fully object-oriented programming language.

---
## Primitive ➡️ Wrapper Mapping 

- int - Integer
- double - Double
- char - Character
- boolean - Boolean

---
## 📦 Boxing 

- Boxing means converting a primitive data type into a wrapper class object. 

``` Integer a = Integer.valueOf(10);```

---
## 📦 Autoboxing 

- Automatic conversion of primitive ➡️ wrapper object.
- Done by the Java compiler.

``` Integer a = 10; ```

---
## 🗳️ Unboxing 

- Converting a wrapper class object back to a primitive type.

``` int n = a.intValue();```

---
## ️ 🗳️ Auto-unboxing

- Automatic conversion of wrapper ➡️ primitive.
- Also handles by the Java compiler.

``` int n = a;```