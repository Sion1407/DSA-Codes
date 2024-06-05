package Exercises.dsaProblems;

//Remove Duplicates from an Unsorted Linked List

//        Given an unsorted Linked List, the task is to remove duplicates from the list.
//
//        Examples:
//
//        Input: linked_list = 12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21
//        Output: 12 -> 11 -> 21 -> 41 -> 43
//        Explanation: Second occurrence of 12 and 21 are removed.
//
//        Input: linked_list = 12 -> 11 -> 12 -> 21 -> 41 -> 43 -> 21
//        Output: 12 -> 11 -> 21 -> 41 -> 43

import LinkedListPrograms.LinkedList1;

import java.util.LinkedList;

public class RemoveDuplicatesFromLL {
    public static void main(String[] args) {
        LinkedList1 linkedList1 = new LinkedList1(12);
        linkedList1.append(11);
        linkedList1.append(12);
        linkedList1.append(21);
        linkedList1.append(41);
        linkedList1.append(43);
        linkedList1.append(21);
        linkedList1.removeDuplicates();
        linkedList1.printList();
    }
}
