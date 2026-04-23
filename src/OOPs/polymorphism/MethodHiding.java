package OOPs.polymorphism;

class Company{
    static void info(){
        System.out.println("General Company");
    }
}
class Google extends Company{
//    void info(){ // ❌ error => instance method cannot override static method
//        System.out.println("Google Company");
//    }

    static void info(){ // No overriding , it is method hiding
        System.out.println("Google Company");
    }
}
public class MethodHiding {
    static void main(String[] args) {
        Company c = new Google();
        c.info(); //  General Company => static method call depends on reference type not object type

        Google g = new Google();
        g.info();  // Google Company
    }

}
