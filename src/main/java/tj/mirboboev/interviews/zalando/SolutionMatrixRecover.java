package tj.mirboboev.interviews.zalando;

public class SolutionMatrixRecover {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, 2, new int[]{2, 1, 1, 0, 1}));
    }

    static class Solution {
        public String solution(int U, int L, int[] C) {
            int[] upperRow = new int[C.length];
            int[] lowerRow = new int[C.length];

            for (int i = 0; i < C.length; i++) {
                if (C[i] == 2) {
                    if (U < 1 || L < 1) {
                        return "IMPOSSIBLE";
                    }

                    upperRow[i] = 1;
                    lowerRow[i] = 1;

                    U -= 1;
                    L -= 1;
                } else if (C[i] == 0) {
                    upperRow[i] = 0;
                    lowerRow[i] = 0;
                } else {

                }
            }

            return join(upperRow) + "," + join(lowerRow);
        }

        private String join(int[] a) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < a.length; i++) {
                result.append(a[i]);
            }

            return result.toString();
        }
    }

}
