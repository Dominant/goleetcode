package tj.mirboboev.challenges;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);

        System.out.println(new Codec().serialize(node));
    }

    public static class Codec {

        public String serialize(TreeNode root) {
            StringBuilder resultBuilder = new StringBuilder();

            if (root == null) {
                return resultBuilder.toString();
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    resultBuilder.append("null,");
                } else {
                    resultBuilder.append(node.val);
                    resultBuilder.append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            return resultBuilder.toString();
        }

        public TreeNode deserialize(String data) {
            List<String> nodes = Arrays.asList(data.split(","));
            Queue<TreeNode> queue = new LinkedList<>();

            TreeNode head = new TreeNode(Integer.parseInt(nodes.get(0)));
            nodes.remove(0);
            queue.add(head);

            while (!nodes.isEmpty()) {
                TreeNode node = queue.poll();

                if (node == null) {
                    continue;
                }

                node.left = new TreeNode(Integer.parseInt(nodes.get(0)));
            }

            return new TreeNode(1);
        }
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
