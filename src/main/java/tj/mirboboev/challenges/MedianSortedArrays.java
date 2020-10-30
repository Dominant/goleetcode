package tj.mirboboev.challenges;

public class MedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(findMedianSortedArrays(new int[]{2}, new int[]{}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedSortedArray = new int[nums1.length + nums2.length];
        int pointerNums1 = 0;
        int pointerNums2 = 0;
        int currentIndex = 0;

        while (pointerNums1 < nums1.length && pointerNums2 < nums2.length) {
            if (nums1[pointerNums1] < nums2[pointerNums2]) {
                mergedSortedArray[currentIndex] = nums1[pointerNums1];
                pointerNums1 += 1;
            } else {
                mergedSortedArray[currentIndex] = nums2[pointerNums2];
                pointerNums2 += 1;
            }

            currentIndex += 1;
        }

        while (pointerNums1 < nums1.length) {
            mergedSortedArray[currentIndex] = nums1[pointerNums1];
            currentIndex += 1;
            pointerNums1 += 1;
        }

        while (pointerNums2 < nums2.length) {
            mergedSortedArray[currentIndex] = nums2[pointerNums2];
            currentIndex += 1;
            pointerNums2 += 1;
        }

        if (mergedSortedArray.length % 2 == 1) {
            return mergedSortedArray[(mergedSortedArray.length / 2)];
        } else  {
            int leftMidIndex = (mergedSortedArray.length / 2) - 1;
            int rightMidIndex = (mergedSortedArray.length / 2);

            return ((double) (mergedSortedArray[leftMidIndex] + mergedSortedArray[rightMidIndex])) / 2;
        }
    }
}
