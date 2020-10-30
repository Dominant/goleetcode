package tj.mirboboev.challenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisappearedNumbersInArray {
    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            seenNumbers.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!seenNumbers.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
}
