package dsa.collections.linkedlist;

public class IntersectionOfTwoLinkedList {
    static void main(String[] args) {

    }
    private static Node getIntersectedNode(Node head, Node head1) {
        int lenA = 0;
        Node tempA = head;
        while(tempA!=null){
            lenA++;
            tempA = tempA.next;
        }
        tempA = head;
        int lenB = 0;
        Node tempB = head1;
        while(tempB !=null){
            lenB++;
            tempB = tempB.next;
        }
        tempB = head1;
        if(lenA>lenB){ // hame barabar tak lana hai dono ko
            for(int i=1; i<=(lenA-lenB); i++){
                tempA = tempA.next;
            }
        }
        else{
            for(int i=1; i<=(lenB-lenA); i++){
                tempB = tempB.next;
            }
        }
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}