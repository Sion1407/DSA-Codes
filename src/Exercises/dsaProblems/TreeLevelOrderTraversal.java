package Exercises.dsaProblems;

//import scala.Int;

import java.util.*;

class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    TreeNode4() {}
    TreeNode4(int val) { this.val = val; }
    TreeNode4(int val, TreeNode4 left, TreeNode4 right) {
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
                this.left = new TreeNode4(value);
                return true;
            } else {
                return this.left.insert(value);
            }
        } else {
            // Insert in the right subtree
            if (this.right == null) {
                this.right = new TreeNode4(value);
                return true;
            } else {
                return this.right.insert(value);
            }
        }
    }

}
public class TreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode4 treeNode4 = new TreeNode4(3);
        treeNode4.insert(9);
        treeNode4.insert(20);
//        treeNode.insert(null);
//        treeNode.insert(null);
        treeNode4.insert(15);
        treeNode4.insert(7);

        System.out.println(levelOrder(treeNode4));
    }
    public static List<List<Integer>> levelOrder(TreeNode4 root) {
        Queue<TreeNode4> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(root.val));
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode4 deq = queue.poll();
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
