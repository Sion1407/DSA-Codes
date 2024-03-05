package Exercises.bstree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(11);
        bst.insert(9);

        System.out.println("root ->"+bst.root.value);
        System.out.println("root -> left " + bst.root.left.value);
        System.out.println("root -> right " +bst.root.right.value);
    }
}
