package LinkedListPrograms;


import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class LinkedList1 {
    private Node head; // Creating vars of class Node
    private Node tail;
    private int length = 0; // to keep track of size of LL

    //        Inner class

    class Node {
        int value;
        Node next;
        // Node means it can point to another node of type Node eg., node.next -> node.value (11 -> 9 -> null)

        public Node(int value) {
            this.value = value;
        }
        public Node(){}
    }

        public LinkedList1(int value) {
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
    public Node getHeadNode() {
        if (head == null) {
            return null;
        } else {
            return head;
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
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    //    removing the tail from the LL
    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length==0){
            head = newNode;
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public Node removeFirst(){
        if (length==0)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length==0)
//            in case of single element in the ll we need the tail would be still pointing to head
            tail = null;
        return head;
    }

    public Node getIndex(int index){
        if (length==0) return null;
        int count = 0;
        Node temp = head;
        if (index>length || index<0) return null;
        while (count!=index){
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public boolean set(int index, int value){
//        if (index>length || index < 0) return false;
//        Node temp = head;
//        int count = 0;
//        while (count!=index){
//            temp = temp.next;
//            count++;
//        }
        Node temp = getIndex(index);
        if (temp!=null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int val){
        if (index==0){
            prepend(val);
            return true;
        } else if (index==length) {
            append(val);
            return true;
        }
        Node newNode = new Node(val);
        Node temp = getIndex(index-1);
        Node tempNext = temp.next;
        if (temp != null) {
            temp.next = newNode;
            newNode.next = tempNext;
            length++;
            return true;
        }
        return false;
    }

    public Node remove(int index){
        if (index == 0) return removeFirst();
        if (index == length-1) return removeLast();
        Node prev = getIndex(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = head;
        Node prev = null;
        Node after;
        int count = 0;
        while (count<length){
            after = temp.next;
            temp.next = prev;
            prev = temp;
            temp = after;
            count++;
        }

    }

    public Node removeDuplicates(){
        Node temp = head;
        Node tempPrev = null;
        List<Integer> checkVals = new ArrayList<>();

        while (temp!=null){
            if (!checkVals.contains(temp.value)){
                checkVals.add(temp.value);
                tempPrev = temp;
                temp = temp.next;
            }
            else{
                Node tempNext = temp.next;
                tempPrev.next = tempNext;
                temp.next = null;
                temp = tempNext;
            }

        }
        return head;
    }
    public static Node checkIntersection(Node headA, Node headB){
        Node tempA = headA;
        Node tempB = headB;

        while (tempB != tempA){
            if (tempA==null){
                tempA = headB;
            }
            else {
                tempA = tempA.next;
            }

            if (tempB == null){
                tempB = headA;
            }
            else {
                tempB = tempB.next;
            }
        }
        return tempA;

    }
    public Node partitionList(Node headA, int x){
        Node left = new Node();
        Node tempLeft = left;
        Node right = new Node();
        Node tempRight = right;
        Node temp = headA;
//        while (temp.value!=x){
//            temp = temp.next;
//        }
        while (temp!=null){
            if (temp.value < x) {
                    tempLeft.next = temp;
                    tempLeft = tempLeft.next;
            }
            else {
                    tempRight.next = temp;
                    tempRight = tempRight.next;
            }
            temp = temp.next;
        }
        tempLeft.next = right.next;
        tempRight.next = null;
//        printing list
//        Node temmp = left.next;
//
//        while (temmp!=null){
//            System.out.println(temmp.value);
//            temmp = temmp.next;
//        }
        return left.next;
    }


}
