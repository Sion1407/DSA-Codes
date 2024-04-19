package Exercises.bstree;

public class BinarySearchTree {
    Node root;
    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        if (root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true){
            if (newNode.value == temp.value) return false;
            if (newNode.value > temp.value){
                if (temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            } else {
                if (newNode.value < temp.value){
                    if (temp.left == null){
                        temp.left = newNode;
                        return true;
                    }
                    temp = temp.left;
                }
            }
        }
    }

    public boolean contains(int value){
        if (root==null) return false;
        Node temp = root;
        while (temp!=null){
            if (temp.value == value) return true;
            else if (temp.value > value) temp = temp.left;
            else  temp = temp.right;
        }
        return false;
    }

//    Using recursion contains method
    public boolean rContains(int val){
        return rContains(root,val);
    }
    private boolean rContains(Node currNode,int val){
        if (currNode == null) return false;
        if (currNode.value == val) return true;

        if (currNode.value > val)
            return rContains(currNode.left,val);
        else
            return rContains(currNode.right,val);
    }

    public void rInsert(int val){
        if (root == null) new Node(val);
        rInsert(root,val);
    }

    private Node rInsert(Node currNode, int val){
        if (currNode == null) return new Node(val);

        if (val < currNode.value){
            currNode.left = rInsert(currNode.left,val);
        } else if (val > currNode.value) {
            currNode.right = rInsert(currNode.right,val);
        }
        return currNode;
    }


}
