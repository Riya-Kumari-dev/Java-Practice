package dsa.strings.mutablestring;

public class Reverse {
    static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Riyaaso");
        //sb.reverse();
        System.out.println(sb);

        int i=0;
        int j = sb.length()-1;
        while(i<j){
            char ch = sb.charAt(i);
            char dh = sb.charAt(j);
            sb.setCharAt(i,dh);
            sb.setCharAt(j,ch);
            i++;
            j--;
        }
        System.out.println(sb); // osaayiR
    }
}
