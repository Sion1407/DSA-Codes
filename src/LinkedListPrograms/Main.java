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

        int value = 20;
        int index2 = 1;
        System.out.println("\nLinked List: setting node at index "+index2+" of value "+value+" is ");
        linkedList1.set(index2,value);
        linkedList1.printList();


        int index3 = 2;
        int value2 = 21;
        System.out.println("\nLinked List: inserting node at index "+index3+" of value "+value2+" is ");
        linkedList1.insert(index3,value2);
        linkedList1.printList();


        System.out.println("\nLinked List: removing node at index "+ 1);
        linkedList1.remove(1);
        linkedList1.printList();

        System.out.println("\nLinked List: reversing a linked list");
        linkedList1.reverse();
        linkedList1.printList();
    }
}