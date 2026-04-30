package dsa.strings.String;

public class Split {
    static void main(String[] args) {
        String s = "Raja Ram Mohan Roy";
        // split() method returns an array of Strings
        String[] str = s.split(" "); // split on the basis of " "
        System.out.println(str.length);
        for(String c : str){
            System.out.print(c+" ");
        }
        // ["Raja","Ram","Mohan","Roy"]
    }
}
