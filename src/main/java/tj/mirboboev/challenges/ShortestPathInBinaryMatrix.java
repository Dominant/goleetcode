package tj.mirboboev.challenges;

import java.util.*;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int n = shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        });
        System.out.println(n);
        n = shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });
        System.out.println(n);
    }

    /**
     * start at 0,0
     * check if it is not blocked
     * <p>
     * add all adjacent cells into the queue
     * increase the move steps
     * mark current node as visited or blocked
     * <p>
     * if we did rich the end of the grid then return move steps
     * <p>
     * if queue is empty and we did not reach end, return -1
     **/

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0) {
            return -1;
        }

        if (grid[0].length == 0) {
            return -1;
        }

        if (grid[0][0] == 1) {
            return -1;
        }

        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();

        Point p = new Point(0, 0, 1);
        queue.add(p);
        visited.add(p);

        int[][] directions = new int[][]{
                {-1, -1},
                {1, 1},
                {-1, 1},
                {1, -1},
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1},
        };

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.x == grid.length - 1 && point.y == grid.length - 1) {
                return point.moveCount;
            }

            for (int[] dir : directions) {
                int x = point.x + dir[0];
                int y = point.y + dir[1];

                // check if x and y is valid point and is not blocked
                // if yes, add it to the queue
                // otherwise move forward
                if (x < 0 || x > grid.length - 1 || y < 0 || y > grid.length - 1) {
                    continue;
                }

                Point next = new Point(x, y);

                if (grid[x][y] != 1 && !visited.contains(next)) {
                    next.moveCount = point.moveCount + 1;
                    queue.add(next);
                    visited.add(next);
                }
            }
        }

        return -1;
    }

    public static class Point {
        int x;
        int y;
        int moveCount = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int moveCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
