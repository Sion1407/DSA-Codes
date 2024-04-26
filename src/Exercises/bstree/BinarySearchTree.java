package Exercises.bstree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
//        Base case scenario
        if (currNode == null) return new Node(val);

        if (val < currNode.value){
            currNode.left = rInsert(currNode.left,val);
        } else if (val > currNode.value) {
            currNode.right = rInsert(currNode.right,val);
        }
        return currNode;
    }

    public int minValue(Node currNode){
        while (currNode.left!=null)
            currNode = currNode.left;
        return currNode.value;
    }
    private Node rDelete(Node currNode, int val){
        if (currNode==null) return null;

        if (val< currNode.value){
            currNode.left = rDelete(currNode.left,val);
        } else if (val > currNode.value) {
            currNode.right = rDelete(currNode.right,val);
        }
        else {
            if (currNode.right==null && currNode.left==null)
                currNode = null;
            else if (currNode.left==null) {
                currNode = currNode.right;
            } else if (currNode.right==null) {
                currNode = currNode.left;
            }
            else {
                int minSubtreeVal = minValue(currNode.right);
                currNode.value = minSubtreeVal;
                currNode.right = rDelete(currNode.right,val);
            }
        }
        return currNode;
    }

    public Node sortedArrayToBST(int[] nums, int left, int right){
        if (left>right) return null;

        int mid = (left+right)/2;
        Node newNode = new Node(nums[mid]);

        newNode.left = sortedArrayToBST(nums, left, mid-1);
        newNode.right = sortedArrayToBST(nums, mid+1, right);

        return newNode;
    }
    public ArrayList<Integer> breadthFirstSearch(){
        Node currNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currNode);
        while (queue.size()>0){
            currNode = queue.remove();
            result.add(currNode.value);
            if (currNode.left!=null)
                queue.add(currNode.left);
            if (currNode.right!=null)
                queue.add(currNode.right);
        }
        return result;
    }

    public ArrayList<Integer> preOrder(){
        ArrayList<Integer> res = new ArrayList<>();
        class Traverse{
            Traverse(Node currNode){
                res.add(currNode.value);
                if (currNode.left!=null)
                    new Traverse(currNode.left);
                if (currNode.right!=null)
                    new Traverse(currNode.right);

            }
        }
        new Traverse(root);
        return res;
    }


}
