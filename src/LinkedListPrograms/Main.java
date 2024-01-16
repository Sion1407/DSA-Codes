package LinkedListPrograms;

public class Main {
    public static void main(String[] args) {
        LinkedList1 linkedList1 = new LinkedList1(4);
        linkedList1.append(3);

        System.out.println("\nLinked List: before removing the last");
        linkedList1.printList();
        System.out.println("\nLinked List: after removing the last:");
//        removed 3
        linkedList1.removeLast();
//        removed 4
        linkedList1.removeLast();
        linkedList1.printList();
    }
}