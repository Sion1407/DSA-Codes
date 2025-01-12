package Exercises.dsaProblems;
class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1() {}
    TreeNode1(int val) { this.val = val; }
    TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class FindDepthOfTheTree {
    public static void main(String[] args) {
        TreeNode1 treeNode1 = new TreeNode1();
        treeNode1.left = new TreeNode1(9);
        treeNode1.right = new TreeNode1(20);
        treeNode1.right.left = new TreeNode1(15);
        treeNode1.right.right = new TreeNode1(7);
        System.out.println(maxDepth(treeNode1));
    }

    public static int maxDepth(TreeNode1 root) {
        if (root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left+1 : right+1;
    }
}
