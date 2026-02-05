package Exercises.bstree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
    }
}

public class Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);

        compute(root);

    }
    private static List<Integer> compute(TreeNode root){

        Map<Integer, ArrayList<Integer>> hm = new HashMap<>();
        diag(root, 0 , hm);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; hm.containsKey(i); i++) {
            for (int val : hm.get(i)) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println(res);
        return res;
    }
    private static void diag(TreeNode root, int lvl , Map<Integer, ArrayList<Integer>> hm){
        if(root == null) return;

        hm.computeIfAbsent(lvl, k-> new ArrayList<>()).add(root.val);
        diag(root.left,lvl, hm);
        diag(root.right,lvl+1, hm);
    }
}
