package LinkedListPrograms;

public class Main {
    public static void main(String[] args) {
        LinkedList1 linkedList1 = new LinkedList1(20);
        linkedList1.append(19);

        System.out.println("\nLinked List: before removing the last");
        linkedList1.printList();
        System.out.println("\nLinked List: after removing the last:");
//        removed 19
        linkedList1.removeLast();
//        removed 20
        linkedList1.removeLast();
        linkedList1.printList();

        System.out.println("\nLinked List: after prepending:");
        linkedList1.append(19);
        linkedList1.prepend(18);
        linkedList1.printList();

        int index = 0;
        System.out.println("\nLinked List: getting node at index "+index+" is ");
        System.out.println(linkedList1.getIndex(index).value);
    }
}