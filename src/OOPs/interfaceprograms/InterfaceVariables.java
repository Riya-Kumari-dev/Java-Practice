package OOPs.interfaceprograms;
interface Config{
    int maxUser = 200; // public static final int maxUser = 200;
}
class App implements Config{
    void users(){
        System.out.println(maxUser);
    }
}
public class InterfaceVariables {
    static void main(String[] args) {
        App p = new App();
        p.users();
        System.out.println(p.maxUser); // Config.maxUser ✅ recommended as it is static
        //p.maxUser = 300; ❌ error cannot assign to final variable
        //System.out.println(p.maxUser);
    }
}
