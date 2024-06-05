package Exercises.bstree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(27);
        bst.insert(52);
        bst.insert(82);

//        System.out.println("root ->"+bst.root.value);
//        System.out.println("root -> left " + bst.root.left.value);
//        System.out.println("root -> right " +bst.root.right.value);
//
//        System.out.println(bst.contains(27));
//
//
//        System.out.println("Using recursive to check bst contains value 27");
//        System.out.println(bst.rContains(27));
//
//        System.out.println("Using recurssion to insert a new Node in BST");
//        bst.rInsert(17);
//        System.out.println(bst.contains(17));
//
//        bst.sortedArrayToBST(new int[]{1,2,3,4,5},0,4);


//        TREE TRAVERSAL
        System.out.println("Breadth first search traversal: ");
        System.out.println(bst.breadthFirstSearch());

        System.out.println("Depth first search traversal: preorder:");
        System.out.println(bst.preOrder());
        System.out.println("Depth first search traversal: postOrder:");
        System.out.println(bst.postOrder());
        System.out.println("Depth first search traversal: inorder:");
        System.out.println(bst.inOrder());

        System.out.println("kth smallest elemetn: ");
        System.out.println(bst.kthSmallest(2));
    }
}
