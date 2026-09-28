package collections.map;

import java.util.*;

class Passport{
    private String name;
    private String city;
    private String country;

    public Passport(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Passport{name= " + name   + ", city= " + city  +   ", country= " + country + "}";
    }
}
public class PassportAuthentication {
    static void main(String[] args) {
        Passport pass1 = new Passport("Riya", "Siwan", "India");
        Passport pass2 = new Passport("Aman", "Mumbai", "India");
        Passport pass3 = new Passport("Rohit", "Pune", "India");

        Integer id1 = 101;
        Integer id2 = 102;
        Integer id3 = 104;

        HashMap<Integer, Passport> hm = new HashMap<>();
        hm.put(id1, pass1);
        hm.put(id2, pass2);
        hm.put(id3, pass3);

        Scanner sc = new Scanner(System.in);
        System.out.print("Kindly enter your passport number : ");
        Integer userN = sc.nextInt();

        Set<Map.Entry<Integer, Passport>> entry = hm.entrySet();
        boolean flag = false;
        Iterator itr = entry.iterator();
        while(itr.hasNext()){
            Map.Entry keyValue = (Map.Entry) itr.next();
            Integer key = (Integer) keyValue.getKey();
            if(key.equals(userN)){
                System.out.println("Please find your details below : ");
                System.out.println(keyValue.getValue());
                flag = true;
            }
        }
        if(!flag){
            System.out.println("Unable to fetch your information based on the given passport id.");
        }
    }
}