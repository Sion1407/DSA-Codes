package Exercises.dsaProblems;

public class ReverseLL2 {
    public static void main(String[] args) {
        LLConst4 ll = new LLConst4(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        LLConst4.ListNode head= reverseBetween(ll.getHeadNode(),2,4 );
        while (head!=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static LLConst4.ListNode reverseBetween(LLConst4.ListNode head, int left, int right) {
        LLConst4.ListNode temp = new LLConst4.ListNode(0);
        temp.next = head;
        LLConst4.ListNode prevLeft = temp;
        LLConst4.ListNode current = head;
//        0 -> 1 -> 2 -> 3 -> 4 -> 5
        int i=0;
        while(i<left-1) {
            prevLeft = prevLeft.next;
            current = current.next;
            i++;
        }
        //        0 -> 1 -> 2 -> 3 -> 4 -> 5
//                   prevL curr
        LLConst4.ListNode start = current;
        LLConst4.ListNode prev = null;
        i=0;
//        3 time (4-2 +1)
        while(i<right-left +1){
            LLConst4.ListNode nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
            i++;
        }
//        1 ->
//      prevL
//        4 -> 3 -> 2 -> null
//                start
        prevLeft.next = prev;
        start.next = current;
        return temp.next;
    }
}
