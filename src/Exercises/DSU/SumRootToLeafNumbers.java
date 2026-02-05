package Exercises.DSU;

//import Exercises.dsaProblems.TreeNode1;

import java.util.ArrayList;
import java.util.List;

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
  }
public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(0);
        treeNode1.left.left = new TreeNode(5);
        treeNode1.left.right = new TreeNode(1);

        System.out.println(sumNumbers(treeNode1));


    }

    static List<String> ls = new ArrayList<>();
    public static int sumNumbers(TreeNode root) {
        int res = 0;
        inOrder(root,new StringBuilder());
        System.out.println(ls);
        return res;
    }

    private static void inOrder(TreeNode root, StringBuilder s){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            s.append(root.val);
            ls.add(s.toString());
            s = new StringBuilder("");
        }
        s.append(root.val);
        inOrder(root.left,s);
        s.deleteCharAt(s.length()-1);
        inOrder(root.right, s);
        // s.deleteCharAt(s.length()-1);
    }
}
