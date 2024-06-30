package Exercises.dsaProblems;

//        24. Swap Nodes in Pairs


import java.util.List;

// CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
//                                                          //
//                                                          //
//                                                          //
//                                                          //
//////////////////////////////////////////////////////////////
class LLConst3 {
    private ListNode head;
    private ListNode tail;
    private int length;

    static class ListNode {
        int value;
        LLConst3.ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode() {
        }
    }

    public LLConst3(int value) {
        LLConst3.ListNode newNode = new LLConst3.ListNode(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public LLConst3() {
        LLConst3.ListNode newNode = new LLConst3.ListNode();
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        LLConst3.ListNode temp = head;
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
        LLConst3.ListNode newNode = new LLConst3.ListNode(value);
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

    public LLConst3.ListNode getHeadNode() {
        if (head == null) {
            return null;
        } else {
            return head;
        }
    }

}

public class SwapWithAdjNodesInLL {
    public static void main(String[] args) {
        LLConst3 llConst3 = new LLConst3(1);
        llConst3.append(2);
        llConst3.append(3);
        llConst3.append(4);
        llConst3.append(5);
        LLConst3.ListNode head3 = swapPairs(llConst3.getHeadNode());
        while (head3!=null){
            System.out.println(head3.value);
            head3 = head3.next;
        }
    }

    public static LLConst3.ListNode swapPairs(LLConst3.ListNode head) {
        if (head==null && head.next==null)
            return head;
        else {
            LLConst3.ListNode curr = head;
            LLConst3.ListNode prev = null;
            LLConst3.ListNode adj = curr.next;
            LLConst3.ListNode adjNxt = adj.next;
            while (adj!=null || curr!=null){
                curr.next = adjNxt;
                if (prev!=null)
                    prev.next = adj;
                else {
                    head = adj;
                }
                adj.next = curr;
//                increment
                prev = curr;
                curr = adjNxt;
                if (curr!=null)
                    adj = curr.next;
                else {
                    break;
                }
                if (adj!=null)
                    adjNxt = adj.next;
                else
                    break;
            }
        }
        return head;
    }
}
