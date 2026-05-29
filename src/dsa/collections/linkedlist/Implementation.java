package dsa.collections.linkedlist;

public class Implementation {
    static void main(String[] args){
        SinglyLinkedList ll = new SinglyLinkedList();
        try {
            // ll.remove(2); // Linked list is empty => no other code will execute in try block
            ll.addAtTail(3);
            ll.addAtTail(4);
            ll.addAtHead(9);
            ll.display(); // [9, 3, 4]
            ll.add(1, 13);
            ll.display(); // [9, 13, 3, 4]
            ll.add(1,56);
            ll.add(2,54);
            ll.add(0,3);
            ll.removeFromEnd();
            ll.display(); // [3, 9, 56, 54, 13, 3]
            ll.size(); // Length of the linked list is 6
            ll.remove(1);
            ll.display(); // [3, 56, 54, 13, 3]
            ll.removeFromHead();
            ll.display(); // [56, 54, 13, 3]
            ll.remove(2);
            ll.set(1,43);
            ll.set(2,76);
            System.out.println(ll.get(1)); // 43
            //System.out.println(ll.get(5)); // Index out of Bound => no other code in try block will be executed
            ll.removeFromEnd();
            ll.display(); // [56, 43]
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}