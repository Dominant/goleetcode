package tj.mirboboev.challenges;

import java.util.*;

public class AllNodesDistanceKinBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        new AllNodesDistanceKinBinaryTree().distanceK(node, node.left, 1);
    }

    private Map<TreeNode, TreeNode> parentChildMap = new HashMap<>();
    private Set<TreeNode> traversedNodes = new HashSet<>();
    private List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildParentChildMap(root, root.left);
        buildParentChildMap(root, root.right);

        dfs(target, K);

        return result;
    }

    private void dfs(TreeNode node, int k) {
        if (traversedNodes.contains(node)) {
            return;
        }

        if (node == null) {
            return;
        }

        traversedNodes.add(node);

        if (k == 0) {
            result.add(node.val);
        }

        dfs(node.left, k - 1);
        dfs(node.right, k - 1);
        dfs(parentChildMap.get(node), k - 1);
    }

    public void buildParentChildMap(TreeNode parent, TreeNode child) {
        if (child == null) {
            return;
        }

        parentChildMap.put(child, parent);

        buildParentChildMap(child, child.left);
        buildParentChildMap(child, child.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
