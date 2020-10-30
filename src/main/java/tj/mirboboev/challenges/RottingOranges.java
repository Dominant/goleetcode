package tj.mirboboev.challenges;

import java.util.*;

public class RottingOranges {
    public static void main(String[] args) {
        System.out.println(new RottingOranges().orangesRotting(
                new int[][]{
                        {2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1},
                }
        ));
        System.out.println(new RottingOranges().orangesRotting(
                new int[][]{
                        {0, 2}
                }
        ));
        System.out.println(new RottingOranges().orangesRotting(
                new int[][]{
                        {1},
                        {2}
                }
        ));
    }

    public int orangesRotting(int[][] grid) {
        int minutesPassed = -1;

        List<Integer[]> rottenOranges = findAllRottenOranges(grid);
        Map<Integer[], Boolean> visited = new HashMap<>();

        if (rottenOranges.size() == 0) {
            if (hasAnyFreshOrange(grid)) {
                return -1;
            } else {
                return 0;
            }
        }

        while (rottenOranges.size() > 0) {
            List<Integer[]> orangesToRotten = new ArrayList<>();
            minutesPassed += 1;

            for (Integer[] rottenOrange : rottenOranges) {
                if (!visited.getOrDefault(rottenOrange, false)) {
                    visited.put(rottenOrange, true);

                    int i = rottenOrange[0];
                    int j = rottenOrange[1];

                    if (i - 1 >= 0) {
                        if (grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 2;
                            orangesToRotten.add(new Integer[]{i - 1, j});
                        }
                    }

                    if (i + 1 < grid.length) {
                        if (grid[i + 1][j] == 1) {
                            grid[i + 1][j] = 2;
                            orangesToRotten.add(new Integer[]{i + 1, j});
                        }
                    }

                    if (j - 1 >= 0) {
                        if (grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 2;
                            orangesToRotten.add(new Integer[]{i, j - 1});
                        }
                    }

                    if (j + 1 < grid[0].length) {
                        if (grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 2;
                            orangesToRotten.add(new Integer[]{i, j + 1});
                        }
                    }
                }
            }

            rottenOranges = orangesToRotten;
        }

        if (hasAnyFreshOrange(grid)) {
            return -1;
        }

        return minutesPassed;
    }

    public static List<Integer[]> findAllRottenOranges(int[][] grid) {
        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    result.add(new Integer[]{i, j});
                }
            }
        }

        return result;
    }

    public static boolean hasAnyFreshOrange(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

}
