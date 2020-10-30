package tj.mirboboev.challenges;

public class NumberOfIslands {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));

        System.out.println(numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));

        System.out.println(numIslands(new char[][]{
                {'1'},
                {'1'}
        }));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numOfIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    private static void dfs(int row, int column, char[][] grid) {
        int gridHeight = grid.length;
        int gridWidth = grid[0].length;

        if (row >= gridHeight || column >= gridWidth || row < 0 || column < 0) {
            return;
        }

        if (grid[row][column] == '1') {
            grid[row][column] = '0';

            dfs(row - 1, column, grid);
            dfs(row + 1, column, grid);
            dfs(row, column - 1, grid);
            dfs(row, column + 1, grid);
        }
    }
}
