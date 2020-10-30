package tj.mirboboev.interviews.zalando;

public class SolutionMinNextInteger {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(28));
        System.out.println(new Solution().solution(734));
        System.out.println(new Solution().solution(1990));
        System.out.println(new Solution().solution(1000));
        System.out.println(new Solution().solution(50000));
    }

    static class Solution {

        public int solution(int N) {
            int sumOfNDigits = sumOfDigits(N);
            int k = N + 1;

            while (sumOfNDigits != sumOfDigits(k)) {
                k++;
            }

            return k;
        }

        private int sumOfDigits(int n) {
            int sum = 0;

            while (n >= 10) {
                sum = sum + n % 10;
                n = n / 10;
            }

            return sum + n;
        }
    }

}
