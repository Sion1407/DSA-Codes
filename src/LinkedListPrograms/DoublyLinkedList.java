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

    public Node removeLast() {
        if (head == null) {
            return null;
        }
        if (length == 1) {
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

    public void prepend(int val) {
        Node newNode = new Node(val);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if (length == 0 || index < 0 || index > length) {
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i != index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index,int val){
        if (index<0 || index>length) return false;
        if (index==0) {
            prepend(val);return true;
        }
        if (index==length){
            appendAtTheEnd(val);return true;
        }
        Node newNode = new Node(val);
        Node before  = get(index-1);
        Node after  = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;
        return true;
    }

    public Node remove(int idx){
        if (idx <0 || idx > length) return null;
        if (idx==0) return removeFirst();
        if (idx==length) return removeLast();
        Node temp = get(idx);
//        Node before = temp.prev;
//        Node after = temp.next;
//        before.next = after;
//        after.prev = before;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = temp.prev = null;
        length--;
        return temp;
    }
}
