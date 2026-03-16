# Encapsulation

## 📝 Meaning 

- Encapsulation means wrapping data (variables) and methods together inside a class. 
- It also means hiding the data from direct access from outside the class.
- 💡 Data is protected and can only be accessed in controlled way.
- **Encapsulation = data + methods + controlled access.**
---
## 🤔 How Encapsulation is Achieved in Java ? 

Encapsulation is achieved by :

- Making variables private.
- Providing public methods(getters and setters) to access and modify the data.
```
class Student{
    private int age;
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
```
---
## ❓ Why Variables are made private ?

Variables are made private to : 

- Prevent modification from outside the class.
- Protect the data.
- Maintain data integrity.

 `s.age = -10; // invalid data`

---
## ❓ Why Methods are made public ?

Methods are public because they : 

- Allow controlled access to private data.
- Can perform validation before changing the data.
- Act as a safe interface to interact with the object.
```
public void setAge(int age){
    if(age > 0) this.age = age;
    else System.out.println("Please enter a valid age")
}
```
---
## 🦾 Benefits of Encapsulation

- Security of data.
- Controlled modification
- Validation of data
- Cleaner and maintainable code