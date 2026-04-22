package OOPs.interfaceprograms;

interface AppFeature{
    default void darkMode(){
        System.out.println("Dark Mode Enabled");
    }
    default void font(){
        System.out.println("Font size is 26");
    }
}
interface WebFeature{
    default void font(){
        System.out.println("Font size is 18");
    }
}
class Whatsapp implements AppFeature{
}
class Telegram implements AppFeature, WebFeature{ // here we have a conflicting method font() present in both interfaces which one should Telegram use
    // so to avoid this Java forces the implementing class to override the conflicting default methods
    public void font(){
        AppFeature.super.font();
    }
}
public class DefaultMethod {
    static void main(String[] args) {
        Whatsapp w = new Whatsapp();
        w.font();
        w.darkMode();

        Telegram t = new Telegram();
        t.font();
        t.darkMode();
    }
}
