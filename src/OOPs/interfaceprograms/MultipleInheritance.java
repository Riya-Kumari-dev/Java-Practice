package OOPs.interfaceprograms;
// Smart device
interface Camera{
    void click();
}
interface MusicPlayer{
    void play();
}
class SmartPhone implements Camera, MusicPlayer{ // Java supports multiple inheritance through interfaces
    public void click(){
        System.out.println("Dhikchaw 😆 Photo Clicked");
    }
    public void play(){
        System.out.println("🎵 Music is playing");
    }
}
public class MultipleInheritance {
    static void main(String[] args) {
        SmartPhone Oppo = new SmartPhone();
        Oppo.click();
        Oppo.play();
    }
}
