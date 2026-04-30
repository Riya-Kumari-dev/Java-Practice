package dsa.strings.mutablestring;

public class DeleteCharacter {
    static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Riyaaso");
        //sb.reverse();
        System.out.println(sb);

        sb.deleteCharAt(5); // TC = O(n)
        System.out.println(sb);
        sb.insert(1,'i'); // TC = O(n)
        System.out.println(sb);

        sb.delete(3,5); // delete from 3 to 4
        System.out.println(sb);
    }
}
