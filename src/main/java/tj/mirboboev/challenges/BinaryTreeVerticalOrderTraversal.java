package tj.mirboboev.challenges;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(verticalOrder(root));
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Map<Integer, List<Integer>>> board = new HashMap<>();
        fillBoard(root, board, 0, 0);

        List<Integer> boardKeys = new ArrayList<>(board.keySet());
        Collections.sort(boardKeys);

        for (int column : boardKeys) {
            List<Integer> boardColumnValues = new ArrayList<>(board.get(column).keySet());
            Collections.sort(boardColumnValues);

            List<Integer> current = new ArrayList<>();

            for (int row : boardColumnValues) {
                current.addAll(board.get(column).get(row));
            }

            result.add(current);
        }

        return result;
    }

    public static void fillBoard(TreeNode node,
                                 Map<Integer, Map<Integer, List<Integer>>> board,
                                 int column,
                                 int row) {
        if (node == null) {
            return;
        }

        Map<Integer, List<Integer>> map = board.getOrDefault(column, new HashMap<>());
        List<Integer> rowValues = map.getOrDefault(row, new ArrayList<>());
        rowValues.add(node.val);

        map.put(row, rowValues);

        board.put(column, map);

        fillBoard(node.left, board, column - 1, row + 1);
        fillBoard(node.right, board, column + 1, row + 1);
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
