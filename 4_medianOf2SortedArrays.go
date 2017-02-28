// https://leetcode.com/problems/median-of-two-sorted-arrays/

package main

import "fmt"

func main() {
	fmt.Println(findMedianSortedArrays([]int{1, 3}, []int{2}))                 // 2
	fmt.Println(findMedianSortedArrays([]int{1, 2}, []int{3, 4}))              // 2.5
	fmt.Println(findMedianSortedArrays([]int{1, 2}, []int{6, 12, 17, 24}))     // 9
	fmt.Println(findMedianSortedArrays([]int{1, 2}, []int{6, 10, 12, 17, 24})) // 10
}

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	if len(nums1) < len(nums2) {
		nums1, nums2 = nums2, nums1
	}

	lenNums1, lenNums2 := len(nums1), len(nums2)
	totalLen := (lenNums1 + lenNums2)

	if totalLen%2 == 1 {

	}

	return float64(lenNums1 + lenNums2)
}
