package dsa.collections.hashmap;

import java.util.HashMap;

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
        // create hashmap of original node and duplicate nodes
        HashMap<Node2, Node2> map = new HashMap<>();
        fillMap(map, head, a);
        // assign random
        assign(map, head, a);
        return a;
    }

    private static void assign(HashMap<Node2, Node2> map, Node2 head, Node2 a) {
        for(Node2 temp : map.keySet()){
            Node2 dup = map.get(temp);
            dup.random = map.get(temp.random);
        }
    }

    private static void fillMap(HashMap<Node2, Node2> map, Node2 head, Node2 a) {
        Node2 temp1 = head;
        Node2 temp2 = a;
        while(temp1 != null){
            map.put(temp1, temp2);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
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