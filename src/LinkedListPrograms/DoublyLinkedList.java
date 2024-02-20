package LinkedListPrograms;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void appendAtTheEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = tail;
            temp.next = newNode;
            newNode.prev = temp;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if (head==null) {
            return null;
        }
        if (length==1){
            head = null;
            tail = null;
        } else {
            Node temp = tail.prev;
            tail.prev = null;
            temp.next = null;
            tail = temp;
        }
        length--;
        return head;
    }

    public void prepend(int val){
        Node newNode = new Node(val);
        if (length==0){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length==0) return null;
        Node temp = head;
        if (length==1){
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }
}
