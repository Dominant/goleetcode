package tj.mirboboev.challenges;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public static void main(String[] args) {
        System.out.println(new MinimumCostToConnectSticks().connectSticks(new int[]{2, 4, 3}));
        System.out.println(new MinimumCostToConnectSticks().connectSticks(new int[]{1,8,3,5}));
    }

    public int connectSticks(int[] sticks) {
        Arrays.sort(sticks);

        if (sticks.length == 0 || sticks.length == 1) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue();

        for (int stick : sticks) {
            queue.add(stick);
        }

        int cost = 0;

        while (queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.poll();

            cost += a + b;
            queue.add(a + b);
        }

        return cost;
    }
}
