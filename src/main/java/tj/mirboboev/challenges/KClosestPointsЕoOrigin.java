package tj.mirboboev.challenges;

import java.util.*;

public class KClosestPointsЕoOrigin {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new KClosestPointsЕoOrigin().kClosest(
                new int[][]{{1, 3}, {-2, 2}},
                1
        )));
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer[]> heap = new PriorityQueue<Integer[]>((o1, o2) -> {
            double dist1 = Math.sqrt(o1[0] * o1[1] + o1[0] * o1[1]);
            double dist2 = Math.sqrt(o2[0] * o2[1] + o2[0] * o2[1]);

            if (dist1 > dist2) {
                return 1;
            } else if (dist2 > dist1) {
                return -1;
            }

            return 0;
        });

        for (int[] point : points) {
            heap.add(new Integer[]{point[0], point[1]});
        }

        int[][] result = new int[K][];

        for (int i = 0; i < K; i++) {
            Integer[] point = heap.poll();
            result[i] = new int[]{point[0], point[1]};
        }

        return result;
    }
}
