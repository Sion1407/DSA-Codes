package Exercises.dsaProblems;

import LinkedListPrograms.LinkedList1;

//import static LinkedListPrograms.LinkedList1.addTwoNumbers;
class LLConst1 {

    // CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
    //                                                          //
    //                                                          //
    //                                                          //
    //                                                          //
    //////////////////////////////////////////////////////////////
    private Node head;
    private Node tail;
    private int length;
    static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(){}
    }

    public LLConst1(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length =1;
    }
    public LLConst1(){
        Node newNode = new Node();
        head = newNode;
        tail = newNode;
        length =1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }
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

    public void getLength() {
        System.out.println("Length: " + length);
    }
    public Node getHeadNode() {
        if (head == null) {
            return null;
        } else {
            return head;
        }
    }

}
public class SumOf2LLIndiNodes {
    public static LLConst1.Node addTwoNumbers(LLConst1.Node l1, LLConst1.Node l2){
        if (l1==null || l2 == null) return null;
        int carry = 0;
        LLConst1.Node temp1 = l1;
        LLConst1.Node temp2 = l2;
        LLConst1.Node head3 = null;
        LLConst1.Node temp = null;
        while (temp2!=null && temp1!=null){

            if (temp == null) {
                if (temp2.value+temp1.value>9){
                    int v = (temp2.value+temp1.value);
                    LLConst1.Node newNode = new LLConst1.Node((v%10)+carry);
                    v = v/10;
                    carry=v;
                    temp = newNode;
                }
                else {
                    LLConst1.Node newNode = new LLConst1.Node(temp1.value + temp2.value+carry);
                    carry = 0;
                    temp = newNode;
                }
                head3 = temp;
            }
            else {
//                check for carry as well +carry
                if (temp2.value + temp1.value > 9 ) {
                    int v = (temp2.value + temp1.value);
                    LLConst1.Node newNode = new LLConst1.Node((v%10)+carry);
                    v= v/10;
                    carry = v;
                    temp.next = newNode;
                    continue;
                } else if (temp2.value + temp1.value+carry > 9) {
                    int v = (temp2.value + temp1.value+carry);
                    LLConst1.Node newNode = new LLConst1.Node(v%10);
                    v= v/10;
                    carry = v;
                    temp.next = newNode;
                } else {
                    LLConst1.Node newNode = new LLConst1.Node(temp1.value + temp2.value+carry);
                    carry = 0;
                    temp.next = newNode;
                }
                temp = temp.next;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (temp1!=null){
            while (temp1!=null) {
                if (temp1.value + carry > 9) {
                    int v = (temp1.value + carry);
                    LLConst1.Node newNode = new LLConst1.Node((v % 10) );
                    v = v / 10;
                    carry = v;
                    temp.next = newNode;

                } else {
                    LLConst1.Node newNode = new LLConst1.Node(temp1.value + carry);
                    carry = 0;
                    temp.next = newNode;
                }
                temp = temp.next;
                temp1 = temp1.next;
            }
        }
        else if (temp2!=null){
            while (temp2!=null) {
                if (temp2.value + carry > 9) {
                    int v = (temp2.value + carry);
                    LLConst1.Node newNode = new LLConst1.Node((v % 10) );
                    v = v / 10;
                    carry = v;
                    temp.next = newNode;

                } else {
                    LLConst1.Node newNode = new LLConst1.Node(temp2.value + carry);
                    carry = 0;
                    temp.next = newNode;
                }
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        if (carry!=0){
            LLConst1.Node newNode = new LLConst1.Node(carry);
            carry = 0;
            temp.next = newNode;
        }
        return head3;
    }
    public static void main(String[] args) {
        LLConst1 linkedList1 = new LLConst1(2);
        linkedList1.append(4);
        linkedList1.append(3);
//        linkedList1.append(9);
//        linkedList1.append(9);
//        linkedList1.append(9);
//        linkedList1.append(9);
        LLConst1 linkedList12= new LLConst1(5);
        linkedList12.append(6);
        linkedList12.append(4);
//        linkedList12.append(9);
        LLConst1.Node head3 =  addTwoNumbers(linkedList1.getHeadNode(),linkedList12.getHeadNode());
        while (head3!=null) {
            System.out.println(head3.value);
            head3 = head3.next;
        }
    }
}
