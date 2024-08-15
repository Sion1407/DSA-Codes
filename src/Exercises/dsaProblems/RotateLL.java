package Exercises.dsaProblems;

class LLConst5 {
    private ListNode head;
    private ListNode tail;
    private int length;

    static class ListNode {
        int value;
        LLConst5.ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode() {
        }
    }

    public LLConst5(int value) {
        LLConst5.ListNode newNode = new LLConst5.ListNode(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public LLConst5() {
        LLConst5.ListNode newNode = new LLConst5.ListNode();
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        LLConst5.ListNode temp = head;
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
        LLConst5.ListNode newNode = new LLConst5.ListNode(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public LLConst5.ListNode getHeadNode() {
        if (head == null) {
            return null;
        } else {
            return head;
        }
    }

}

public class RotateLL {
    public static void main(String[] args) {
        LLConst5 listNode= new LLConst5(0);
//        listNode.append(0);
        listNode.append(1);
        listNode.append(2);
//        listNode.append(4);
//        listNode.append(5);
        LLConst5.ListNode head3 = rotateRight(listNode.getHeadNode(),4);
        while (head3!=null){
            System.out.println(head3.value);
            head3 = head3.next;
        }


    }

    public static LLConst5.ListNode rotateRight(LLConst5.ListNode head, int k) {
        if (head==null || head.next==null) return head;
        LLConst5.ListNode temp = head;
        LLConst5.ListNode tail = head;
        LLConst5.ListNode tailPrev= null;

        while (k!=0){
            while (tail.next!=null){
                tailPrev = tail;
                tail = tail.next;
            }
            tailPrev.next = null;
            tail.next = temp;
            head = tail;
            temp = head;
            k--;
        }
        return head;
    }
}
