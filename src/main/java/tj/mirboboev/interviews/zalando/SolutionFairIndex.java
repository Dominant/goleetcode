package tj.mirboboev.interviews.zalando;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionFairIndex {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{4, -1, 0, 3}, new int[]{-2, 5, 0, 3}));
        System.out.println(new Solution().solution(new int[]{2, -2, -3, 3}, new int[]{0, 0, 4, -4}));
        System.out.println(new Solution().solution(new int[]{4, -1, 0, 3}, new int[]{-2, 6, 0, 4}));
        System.out.println(new Solution().solution(new int[]{3, 2, 6}, new int[]{4, 1, 6}));
        System.out.println(new Solution().solution(new int[]{1, 4, 2, -2, 5}, new int[]{7, -2, -2, 2, 5}));
    }

    static class Solution {
        public int solution(int[] A, int[] B) {
            int fairIndexesCount = 0;

            int leftSumA = A[0];
            int leftSumB = B[0];
            int rightSumA = sumOfArray(A) - A[0];
            int rightSumB = sumOfArray(B) - B[0];

            int i = 1;

            while (i < A.length) {
                Set set = new HashSet<>(Arrays.asList(leftSumA, leftSumB, rightSumA, rightSumB));

                if (set.size() == 1) {
                    fairIndexesCount++;
                }

                i++;

                leftSumA += A[i - 1];
                rightSumA -= A[i - 1];

                leftSumB += B[i - 1];
                rightSumB -= B[i - 1];
            }

            return fairIndexesCount;
        }

        private int sumOfArray(int[] a) {
            int sum = 0;

            for (int elem : a) {
                sum += elem;
            }

            return sum;
        }
    }
}
