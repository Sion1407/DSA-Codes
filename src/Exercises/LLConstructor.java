
// THIS GOES IN YOUR MAIN CLASS TO TEST YOUR CODE:
// -----------------------------------------------

package Exercises;

public class LLConstructor {

    public static void main(String[] args) {

        LLConstructor1 myLinkedList = new LLConstructor1(4);


        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

        System.out.println("\nLinked List:");
        myLinkedList.printList();

    }

}





// THIS CODE GOES IN YOUR LINKEDLIST CLASS:
// ----------------------------------------




class LLConstructor1 {

    // CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
    //                                                          //
    //                                                          //
    //                                                          //
    //                                                          //
    //////////////////////////////////////////////////////////////
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public LLConstructor1(int value){
        Node newNode = new Node(value);
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

    public void getLength() {
        System.out.println("Length: " + length);
    }

}

