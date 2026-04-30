package dsa.strings.String;

public class BuiltInMethod {
    static void main(String[] args) {
        String s = "RajaRamMohanRoy";
        System.out.println(s.length()); // 15
        System.out.println(s.toUpperCase()); // RAJARAMMOHANROY
        System.out.println(s.toLowerCase()); // rajarammohanroy
        System.out.println(s.charAt(4)); // R
        System.out.println(s.substring(2,10)); // 2 to 9 => jaRamMoh
        System.out.println(s.indexOf('a')); // 1
        System.out.println(s.indexOf("Ram")); // 4
        System.out.println(s.lastIndexOf('a')); // 10
        System.out.println(s.contains("Mohan")); // true
        System.out.println(s.startsWith("Raj")); // true
        char[] arr = s.toCharArray(); // [R, a, j,a, R, a, m, M, o, h, a,n, R, o, y]
        for(char ch : arr){
            System.out.print(ch+" ");
        }
        System.out.println();
        String s2 = "1234";
        int n = Integer.parseInt(s2);
        System.out.println(n); // 1234
    }
}
