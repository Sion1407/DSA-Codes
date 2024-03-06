package Exercises.bstree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(47);
        bst.insert(21);
        bst.insert(75);
        bst.insert(18);
        bst.insert(27);
        bst.insert(52);
        bst.insert(82);

        System.out.println("root ->"+bst.root.value);
        System.out.println("root -> left " + bst.root.left.value);
        System.out.println("root -> right " +bst.root.right.value);

        System.out.println(bst.contains(27));
    }
}
