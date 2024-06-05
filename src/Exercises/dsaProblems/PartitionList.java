package Exercises.dsaProblems;

import LinkedListPrograms.LinkedList1;
import org.w3c.dom.Node;

public class PartitionList {
    public static void main(String[] args) {
        LinkedList1 linkedList1 = new LinkedList1(1);
        linkedList1.append(4);
        linkedList1.append(3);
        linkedList1.append(2);
        linkedList1.append(5);
        linkedList1.append(2);
        linkedList1.partitionList(linkedList1.getHeadNode(),3);
    }
}
