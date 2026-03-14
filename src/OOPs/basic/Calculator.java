package OOPs.basic;

class Calc{
    int num1;
    int num2;
    void add(){
        num1 = 5;
        num2 = 10;
        System.out.println(num1+num2);
    }
}
public class Calculator {
    static void main(String[] args){
        Calc c = new Calc();
        c.add();
    }
}