package tj.mirboboev.challenges;

import java.util.ArrayList;
import java.util.List;

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

    static class MedianFinder {
        List<Integer> nums = new ArrayList<>();

        public MedianFinder() {
        }

        public void addNum(int num) {
            nums.add(num);
            int insertedIndex = nums.size() - 1;

            if (nums.size() == 1) {
                return;
            }

            while (insertedIndex > 0 && (nums.get(insertedIndex) < nums.get(insertedIndex - 1))) {
                int temp = nums.get(insertedIndex);
                nums.set(insertedIndex, nums.get(insertedIndex - 1));
                nums.set(insertedIndex - 1, temp);
                insertedIndex -= 1;
            }
        }

        public double findMedian() {
            int size = nums.size();

            if (size % 2 == 1) {
                return nums.get(size / 2);
            } else {
                int left = nums.get(size / 2 - 1);
                int right = nums.get(size / 2);

                return (double) (left + right) / 2;
            }
        }
    }
}
