package LinkedListPrograms;



public class LinkedList1 {
    private Node head; // Creating vars of class Node
    private Node tail;
    private int length; // to keep track of size of LL

//        Inner class
        class Node{
            int value;
            Node next;
            // Node means it can point to another node of type Node eg., node.next -> node.value (11 -> 9 -> null)

            public Node(int value){
                this.value = value;
            }
        }
    public LinkedList1(int value){
//        Node for declaring var of type node  =  runs/calls the constructor method of Node
//        newNode -> value
        Node newNode = new Node(value);
        head = newNode;
//        head -> value or newNode/head -> value
        tail = newNode;
        length = 1;
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void printList() {
        LinkedList1.Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

//    adding new values to the LinkedList
    public void append(int value){
            Node newNode = new Node(value);
            if (length == 0){
                head = newNode;
                tail = newNode;
            }
            tail.next = newNode;
            tail = newNode;
            length++;
    }

//    removing the tail from the LL
    public Node removeLast(){
            if (length==0){
                return null;
            }
            if (length==1){
                head = null;
                tail = null;
                return null;
            }
            Node prevTail = head;
            while (prevTail.next != tail){
                prevTail = prevTail.next;
            }

            tail = prevTail;
            tail.next = null;
            length--;
            return head;
    }
}
