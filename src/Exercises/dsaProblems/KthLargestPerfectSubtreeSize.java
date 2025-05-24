package Exercises.dsaProblems;

import java.util.PriorityQueue;

//3319
  class TreeNode {
      int val;
      TreeNode4 left;
      TreeNode4 right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode4 left, TreeNode4 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
public class KthLargestPerfectSubtreeSize {
    public static void main(String[] args) {
        TreeNode4 treeNode4 = new TreeNode4(5);
        treeNode4.left = new TreeNode4(3);
        treeNode4.left.left = new TreeNode4(5);
        treeNode4.left.right = new TreeNode4(2);
        treeNode4.left.left.left = new TreeNode4(1);
        treeNode4.left.left.right = new TreeNode4(8);

        treeNode4.right = new TreeNode4(6);
        treeNode4.right.left = new TreeNode4(5);
        treeNode4.right.right = new TreeNode4(7);
        treeNode4.right.left.left = new TreeNode4(6);
        treeNode4.right.left.right = new TreeNode4(8);

        System.out.println(kthLargestPerfectSubtree(treeNode4,2));
    }
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    public static int kthLargestPerfectSubtree(TreeNode4 root, int k) {
        helper(root,k);
        if (q.size()<k){
            return -1;
        }
        return q.peek();
    }
    private static int helper(TreeNode4 root, int k){
        if(root==null){
            return 0;
        }
        int left = helper(root.left,k);
        int right = helper(root.right,k);
        if ((root.left!=null && root.right==null) ||
                (root.left==null && root.right!=null)){
            return -1;
        }
        if (left==-1 || right==-1 || left!=right){
            return -1;
        }
        if (q.size()<k){
            q.add(left+right+1);
        }
        else{
            if (q.peek() < left+right+1){
                q.poll();
                q.add(left+right+1);
            }
        }
        return left+right+1;
    }
}
