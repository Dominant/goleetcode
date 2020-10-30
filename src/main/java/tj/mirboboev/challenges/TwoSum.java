package tj.mirboboev.challenges;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenNumbers = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (seenNumbers.containsKey(target - nums[i])) {
                return new int[]{i, seenNumbers.get(target - nums[i])};
            } else {
                seenNumbers.put(nums[i], i);
            }
        }

        return result;
    }
}
