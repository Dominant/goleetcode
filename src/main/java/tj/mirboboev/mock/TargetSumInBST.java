package tj.mirboboev.mock;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class TargetSumInBST {
    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> seenNumbers = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            TreeNode current = queue.poll();
            if (seenNumbers.contains(k - current.val)) {
                return true;
            }

            seenNumbers.add(current.val);

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return false;
    }

    public class TreeNode {
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
