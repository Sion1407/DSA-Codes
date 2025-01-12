package Exercises.dsaProblems;

import java.util.PriorityQueue;

//3319
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
public class KthLargestPerfectSubtreeSize {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.left.left = new TreeNode(1);
        treeNode.left.left.right = new TreeNode(8);

        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.left.left = new TreeNode(6);
        treeNode.right.left.right = new TreeNode(8);

        System.out.println(kthLargestPerfectSubtree(treeNode,2));
    }
    static PriorityQueue<Integer> q = new PriorityQueue<>();
    public static int kthLargestPerfectSubtree(TreeNode root, int k) {
        helper(root,k);
        if (q.size()<k){
            return -1;
        }
        return q.peek();
    }
    private static int helper(TreeNode root, int k){
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
