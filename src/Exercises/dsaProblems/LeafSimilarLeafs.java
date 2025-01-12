package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2() {}
    TreeNode2(int val) { this.val = val; }
    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LeafSimilarLeafs {

    public static void main(String[] args) {
        TreeNode2 treeNode2 = new TreeNode2(3);
        treeNode2.left = new TreeNode2(5);
        treeNode2.left.left = new TreeNode2(6);
        treeNode2.left.right = new TreeNode2(2);
        treeNode2.left.right.left = new TreeNode2(7);
        treeNode2.left.right.right = new TreeNode2(4);

        treeNode2.right = new TreeNode2(1);
        treeNode2.right.left = new TreeNode2(9);
        treeNode2.right.right = new TreeNode2(8);

        TreeNode2 treeNode3 = new TreeNode2(3);
        treeNode3.left = new TreeNode2(5);
        treeNode3.left.left = new TreeNode2(6);
        treeNode3.left.right = new TreeNode2(2);
        treeNode3.left.right.left = new TreeNode2(7);
        treeNode3.left.right.right = new TreeNode2(4);

        treeNode3.right = new TreeNode2(1);
        treeNode3.right.left = new TreeNode2(9);
        treeNode3.right.right = new TreeNode2(8);

        System.out.println(leafSimilar(treeNode2,treeNode3));
    }

    static List<Integer> rl1 = new ArrayList<>();
    static List<Integer> rl2 = new ArrayList<>();
    public static boolean leafSimilar(TreeNode2 root1, TreeNode2 root2) {
        Map<Integer,Integer> hm = new HashMap<>();
        helper(root1);
        helper2(root2);
        return rl1.equals(rl2) ? true : false;
    }

    private static void helper(TreeNode2 r1){
        if (r1==null)
            return;
        if (r1.left==null && r1.right==null)
            rl1.add(r1.val);
        helper(r1.left);
        helper(r1.right);
    }
    private static void helper2(TreeNode2 r1){
        if (r1==null)
            return;
        if (r1.left==null && r1.right==null)
            rl2.add(r1.val);
        helper2(r1.left);
        helper2(r1.right);
    }
}
