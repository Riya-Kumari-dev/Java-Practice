package OOPs.polymorphism;
class Security{
    final void login(){
        System.out.println("Secure login");
    }
}
class User extends Security{
//    void login(){ // ❌ error cannot override final method
//        System.out.println("Custom login");
//    }
}
public class FinalMethod {
    static void main(String[] args) {
        Security s = new User();
        s.login(); // Secure login
    }
}
