package Exercises.dsaProblems;

// * Definition for a binary tree node.
class TreeNode3 {
      int val;
      TreeNode3 left;
      TreeNode3 right;
      TreeNode3() {}
      TreeNode3(int val) { this.val = val; }
      TreeNode3(int val, TreeNode3 left, TreeNode3 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class LongestUniValuePath {
    public static void main(String[] args) {
        TreeNode3 t = new TreeNode3(5);
        t.left = new TreeNode3(4);
        t.left.left = new TreeNode3(1);
        t.left.right = new TreeNode3(1);
        t.right = new TreeNode3(5);
        t.right.right = new TreeNode3(5);
        System.out.println(longestUnivaluePath(t));
    }
    static int max = 0;
    public static int longestUnivaluePath(TreeNode3 root) {
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode3 root){
        if (root == null)
            return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);

        int le = (root.left!=null && root.left.val== root.val) ? l+1:0;
        int re = (root.right!=null && root.right.val== root.val) ? r+1:0;
        max = Math.max(max,le+re);

        return Math.max(le,re);
    }
}
