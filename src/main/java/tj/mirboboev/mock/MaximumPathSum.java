package tj.mirboboev.mock;

public class MaximumPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(-2), new TreeNode(3));
        maxPathSum(root);
    }

    public static int maxPathSum(TreeNode root) {
        return 0;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
