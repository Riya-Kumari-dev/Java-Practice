package dsa.collections.linkedlist;
class Node2{
    int val;
    Node2 next;
    Node2 random;
    Node2(int val){
        this.val = val;
    }
}
public class CopyListWithRandomPointer {
    static void main(String[] args) {
        Node2 a = new Node2(7);
        Node2 b = new Node2(13);
        Node2 c = new Node2(11);
        Node2 d = new Node2(10);
        Node2 e = new Node2(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        print(a);
        Node2 newHead = copyRandomList(a);
        print(newHead);
    }

    private static Node2 copyRandomList(Node2 head) {
        if(head == null) return null;
        // first create a deep copy with only next and val no random
        Node2 a = deepCopy(head);
        // make alternate connections with the original list
        Node2 b = alternateConnect(a, head);
        // assign random pointers
        Node2 c = assignRandom(b);
        // break the alternate connections
        return breakConnection(c);
    }

    private static Node2 breakConnection(Node2 c) {
        Node2 newHead = c.next;
        Node2 t1 = c;
        Node2 t2 = newHead;
        while(t2 != null){
            t1.next = t2.next;
            t1 = t1.next;
            if(t1 == null) break;
            t2.next = t1.next;
            t2 = t2.next;
        }
        return newHead;
    }

    private static Node2 assignRandom(Node2 b) {
        Node2 t1 = b;
        Node2 t2;
        while(t1 != null){
            t2 = t1.next;
            if(t1.random != null) t2.random = t1.random.next;
            t1 = t1.next.next;
        }
        return b;
    }

    private static Node2 alternateConnect(Node2 deep, Node2 head) {
        Node2 t1 = head;
        Node2 t2 = deep;
        Node2 dummy = new Node2(-1);
        Node2 temp = dummy;
        while(t1 != null && t2 != null){
            temp.next = t1;
            t1 = t1.next;
            temp = temp.next;

            temp.next = t2;
            t2 = t2.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    private static Node2 deepCopy(Node2 head) {
        Node2 temp = head;
        Node2 dummy = new Node2(-1);
        Node2 t = dummy;
        while(temp != null){
            t.next = new Node2(temp.val);
            temp = temp.next;
            t = t.next;
        }
        return dummy.next;
    }

    private static void print(Node2 a) {
        Node2 temp = a;
        System.out.print("[");
        while(temp != null){
            System.out.print("["+temp.val+","+((temp.random !=null) ? temp.random.val : null)+"]");
            if(temp.next != null) System.out.print(",");
            temp = temp.next;
        }
        System.out.println("]");
    }
}