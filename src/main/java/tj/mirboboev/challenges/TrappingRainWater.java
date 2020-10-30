package tj.mirboboev.challenges;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new TrappingRainWater().trap(new int[]{4, 2, 3}));
    }

    public int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }

        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum += (leftMax - height[left]);
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    sum += (rightMax - height[right]);
                }
                right--;
            }
        }

        return sum;
    }
}
