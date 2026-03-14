package OOPs;

class Calculator{
    // method overloading refers to creating multiple methods within the same class with same name but diff parameters.
    // method overloading does not depend on return type

    // here no such method is present which is overloaded to multiple tasks thus it is just an illusion as these are completely separate methods
    // selection happens at compile time
    // also known as false polymorphism or compile time polymorphism

    int add(int n1, int n2){
        return n1 + n2;
    }
    int add(int n1, int n2, int n3){
        return n1 + n2 + n3;
    }
    double add(int n1 , int n2, double n3){
        return n1 + n2 + n3;
    }
    double add(int n1, double n2){
        return n1 + n2;
    }
    double add(double n1, int n2){
        return n1+n2;
    }
    double add(double n1, double n2){
        return n1+n2;
    }
}

public class MethodOverloading {
    public static void main(String[] args){
        Calculator c = new Calculator();

        System.out.println(c.add(1,2)); // if I remove the int, int method then compiler will show error because of ambiguity -> whether the compiler should go with double, int or int, double method
        System.out.println(c.add(1,4,2));
        System.out.println(c.add(1,2.0));
    }
}
