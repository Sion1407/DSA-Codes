package Exercises.dsaProblems.LinkedList;

import LinkedListPrograms.LinkedList1;

public class CodingNinjasLL {
    public static void main(String[] args) {
        LinkedList1 linkedList1 = new LinkedList1(1);
        linkedList1.append(2);
        linkedList1.append(3);
        linkedList1.append(4);
        linkedList1.append(5);
        linkedList1.codingNinjasLL(linkedList1.getHeadNode());
        linkedList1.printList();
    }
}
