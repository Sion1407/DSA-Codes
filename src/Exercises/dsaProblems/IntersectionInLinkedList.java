package Exercises.dsaProblems;

import LinkedListPrograms.LinkedList1;

import static LinkedListPrograms.LinkedList1.checkIntersection;

public class IntersectionInLinkedList {
    public static void main(String[] args) {
        LinkedList1 ll1 = new LinkedList1(4);
        ll1.append(1);
        ll1.append(8);
        ll1.append(4);
        ll1.append(5);
        LinkedList1 ll2 = new LinkedList1(5);
        ll2.append(6);
        ll2.append(1);
        ll2.append(8);
        ll2.append(4);
        ll2.append(5);
        System.out.println(checkIntersection(ll1.getHeadNode(),ll2.getHeadNode()));
    }


}
