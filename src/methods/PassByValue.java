package methods;

public class PassByValue {
    public static void main(String[] args){
        int x = 4;
        System.out.println(x);
        change(x);
        System.out.println(x);
    }
    static void change(int x){ // pass by value
        x = 10;
    }
}
