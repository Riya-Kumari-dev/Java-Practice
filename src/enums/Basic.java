package enums;

enum Day{
    MON, TUE, WED, THU, SAT, SUN;
}
public class Basic{
    static void main(String[] args) {
        Day today = Day.WED;
        // name()
        // returns the exact declared name
        System.out.println("Name : " + today.name()); // WED

        // ordinal()
        // returns the zero based position of the constant
        System.out.println("Ordinal : " + today.ordinal()); // 2

        // values()
        // returns an array containing all enum constants.
        System.out.println("Day in a week : ");
        for(Day d : Day.values()){
            System.out.println(d);
        }

        // valueOf()
        // converts a matching string into an enum constant
        Day tomorrow = Day.valueOf("THU");
        System.out.println("Tomorrow is " + tomorrow); // THU

        // toString()
        // By default it returns the enum constant's name
        System.out.println("ToString : "+today.toString()); // WED
    }
}