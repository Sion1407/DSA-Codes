package Exercises.dsaProblems;

public class PathSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);

        treeNode.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(treeNode, 22));

    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum);
    }

    private static boolean dfs(TreeNode r, int t){
        if (r == null) {
            return false;
        }
        if (r.left==null && r.right==null)
            return t == r.val;
        boolean left = dfs(r.left,t - r.val);
        boolean right = dfs(r.right,t - r.val);
        return left || right;
    }
}
