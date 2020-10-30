package tj.mirboboev.challenges;

import java.util.Arrays;

public class PrisonCellsAfterNDays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(
                new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7
        )));

        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(
                new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000
        )));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {

        for (int i = 0; i < N; i++) {
            int prev = cells[0];

            for (int j = 1; j < cells.length - 1; j++) {
                boolean occupy = false;
                if (prev == cells[j + 1]) {
                    occupy = true;
                }

                prev = cells[j];

                if (occupy) {
                    cells[j] = 1;
                } else {
                    cells[j] = 0;
                }
            }

            cells[0] = 0;
            cells[cells.length - 1] = 0;
        }

        return cells;
    }
}
