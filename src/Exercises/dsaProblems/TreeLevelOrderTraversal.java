package Exercises.dsaProblems;

//import scala.Int;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public boolean insert(Integer value) {
        if (value == this.val) {
            // Duplicate values are not allowed in BST, return false if value already exists
            return false;
        } else if (value < this.val) {
            // Insert in the left subtree
            if (this.left == null) {
                this.left = new TreeNode(value);
                return true;
            } else {
                return this.left.insert(value);
            }
        } else {
            // Insert in the right subtree
            if (this.right == null) {
                this.right = new TreeNode(value);
                return true;
            } else {
                return this.right.insert(value);
            }
        }
    }

}
public class TreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.insert(9);
        treeNode.insert(20);
//        treeNode.insert(null);
//        treeNode.insert(null);
        treeNode.insert(15);
        treeNode.insert(7);

        System.out.println(levelOrder(treeNode));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(root.val));
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode deq = queue.poll();
            temp = new ArrayList<>();
            if (deq.left!=null){
                queue.add(deq.left);
                temp.add(deq.left.val);
            }if (deq.right!=null){
                queue.add(deq.right);
                temp.add(deq.right.val);
            }
            res.add(temp);
        }
        return res;
    }

}
