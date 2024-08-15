package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

//3217
class LLConst4 {

    // CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
    //                                                          //
    //                                                          //
    //                                                          //
    //                                                          //
    //////////////////////////////////////////////////////////////
    private ListNode head;
    private ListNode tail;
    private int length;
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int value){
            this.val = value;
        }
        public ListNode(){}
    }

    public LLConst4(int value){
        ListNode newNode = new ListNode(value);
        head = newNode;
        tail = newNode;
        length =1;
    }
    public LLConst4(){
        ListNode newNode = new ListNode();
        head = newNode;
        tail = newNode;
        length =1;
    }

    public void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.val);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.val);
        }
    }
    public void append(int value) {
        ListNode newNode = new ListNode(value);
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
    public ListNode getHeadNode() {
        if (head == null) {
            return null;
        } else {
            return head;
        }
    }

}
public class DeleteElementsPresntInArray {
    public static void main(String[] args) {
        LLConst4 ll = new LLConst4(1);
//        ll.append(1);
        ll.append(2);
        ll.append(1);
        ll.append(2);
        ll.append(1);ll.append(2);
        LLConst4.ListNode head= modifiedList(new int[]{1,2,3},ll.getHeadNode());
        while (head!=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static LLConst4.ListNode modifiedList(int[] nums, LLConst4.ListNode head) {
        List<Integer> n = new ArrayList(nums.length);
        for (int i: nums){
            n.add(i);
        }
        if (head==null){
            return head;
        } else if (head.next==null) {
            if (n.contains(head.val)){
                return null;
            }
            else return head;
        }
        LLConst4.ListNode prev = null;
        LLConst4.ListNode curr = head;
        LLConst4.ListNode next = curr.next;
        while(curr.next!=null){
            if (n.contains(curr.val)){
                if (prev!=null){
                    prev.next = next;
                    curr.next = null;
                    curr = next;
                    next = next.next;
                }
                else {
                    head = next;
                    curr.next = null;
                    curr = next;
                    next = next.next;
                }
            }
            else {
                prev = curr;
                curr = next;
                next = next.next;
            }
        }
        if (curr!=null && n.contains(curr.val)){
            if (prev!=null)
                prev.next = null;
            else
                return null;
        }
        return head;

    }
}
