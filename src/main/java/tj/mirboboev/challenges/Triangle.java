package tj.mirboboev.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Triangle {
    public static void main(String[] args) {
        int r = minimumTotal(
                Arrays.asList(
                    Arrays.asList(2),
                        Arrays.asList(3,4),
                        Arrays.asList(6,5,7),
                        Arrays.asList(4,1,8,3)
                )
        );

        System.out.println(r);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        if (triangle.size() == 2) {
            return triangle.get(0).get(0) + Math.min(
                    triangle.get(1).get(0),
                    triangle.get(1).get(1));
        }

        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();

        int minLeft = minPath(1, 0, cache, triangle);
        int minRight = minPath(1, 1, cache, triangle);

        return triangle.get(0).get(0) + Math.min(minLeft, minRight);
    }

    public static int minPath(int row, int index, Map<Integer, Map<Integer, Integer>> cache, List<List<Integer>> triangle) {
        if (cache.containsKey(row)) {
            if (cache.get(row).containsKey(index)) {
                return cache.get(row).get(index);
            }
        }

        int n = triangle.get(row).get(index);

        if (row == triangle.size() - 2) {
            return n + Math.min(
                    triangle.get(row + 1).get(index),
                    triangle.get(row + 1).get(index + 1));
        }

        int min = n + Math.min(
                minPath(row + 1, index, cache, triangle),
                minPath(row + 1, index + 1, cache, triangle));

        Map<Integer, Integer> cc = cache.getOrDefault(row, new HashMap<>());
        cc.put(index, min);
        cache.put(row, cc);

        return min;
    }
}
