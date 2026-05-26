package dsa.collections.linkedlist;
class MultiNode{
    int val;
    MultiNode next;
    MultiNode prev;
    MultiNode child;
    MultiNode(int val){
        this.val = val;
    }

}
public class FlattenMultilevelDoublyLinkedList {
    static void main(String[] args) {
        MultiNode a = new MultiNode(1);
        MultiNode b = new MultiNode(2);
        MultiNode c = new MultiNode(3);
        MultiNode d = new MultiNode(4);
        MultiNode e = new MultiNode(5);
        MultiNode f = new MultiNode(6);
        MultiNode g = new MultiNode(7);
        MultiNode h = new MultiNode(8);
        MultiNode i = new MultiNode(9);
        MultiNode j = new MultiNode(10);
        MultiNode k = new MultiNode(11);
        MultiNode l = new MultiNode(12);

        // connect
        a.next = b;
        b.next = c; b.prev = a;
        c.next = d; c.prev = b;
        d.next = e; d.prev = c;
        e.next = f; e.prev = d;
        f.prev = e;

        c.child = g;
        g.next = h;
        h.next = i; h.prev = g;
        i.next = j; i.prev = h;
        j.prev = i;

        h.child = k;
        k.next = l;
        l.prev = k;

        MultiNode head = flatten(a);
        display(head);

    }

    private static void display(MultiNode head) {
        MultiNode temp = head;
        System.out.print("[");
        while(temp != null){
            System.out.print(temp.val);
            if(temp.next != null) System.out.print(",");
            temp = temp.next;
        }
        System.out.println("]");
    }

    private static MultiNode flatten(MultiNode head){
        MultiNode temp = head;
        MultiNode c = null; // for next
        MultiNode t = null; // for child
        while(temp != null){
            c = temp.next;
            if(temp.child!=null){
                t = temp.child;
                flatten(t);
                temp.child = null; // mark that it has been flattened
                // connect the nodes
                temp.next = t;
                t.prev = temp;
                while(t.next != null) t = t.next;
                if(c!=null) c.prev = t;
                t.next = c;
            }
            // next iteration
            temp = c;
        }
        return head;
    }
}
