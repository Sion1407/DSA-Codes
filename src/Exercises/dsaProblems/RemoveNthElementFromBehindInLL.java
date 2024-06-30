package Exercises.dsaProblems;

class LLConst2 {

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
        int value;
        ListNode next;

        public ListNode(int value){
            this.value = value;
        }
        public ListNode(){}
    }

    public LLConst2(int value){
        ListNode newNode = new ListNode(value);
        head = newNode;
        tail = newNode;
        length =1;
    }
    public LLConst2(){
        ListNode newNode = new ListNode();
        head = newNode;
        tail = newNode;
        length =1;
    }

    public void printList() {
        ListNode temp = head;
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

public class RemoveNthElementFromBehindInLL {
    public static void main(String[] args) {
        LLConst2 llConst2 = new LLConst2(1);
        llConst2.append(2);
        llConst2.append(3);
//        llConst2.append(4);
//        llConst2.append(5);
        LLConst2.ListNode head2 = removeNthFromEnd(llConst2.getHeadNode(),3);
        while (head2!=null) {
            System.out.println(head2.value);
            head2 = head2.next;
        }

    }

    public static LLConst2.ListNode removeNthFromEnd(LLConst2.ListNode head, int n){
        int len = 0;
        LLConst2.ListNode temp = head;
        while (temp!=null) {
            temp = temp.next;
            len++;
        }
        if (n==1 && len==1){
            return null;
        }
        else{
            int toRemoveLen = len-n;
            LLConst2.ListNode curr = head;
            LLConst2.ListNode prev = null;
            LLConst2.ListNode currNext = head.next;
            if (toRemoveLen==0){
                curr.next= null;
                head = currNext;
                return head;
            }
            else {
                while (toRemoveLen!=0){
                    prev = curr;
                    curr = curr.next;
                    currNext = currNext.next;
                    toRemoveLen--;
                }
                if (prev!=null){
                    prev.next = currNext;
                    curr.next = null;
                }
                else {
                    curr.next = null;
                }
            }
        }
        return head;

    }


}
