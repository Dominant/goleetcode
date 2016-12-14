package main

import (
	"fmt"
)

func main() {
	result := twoSum([]int{2, 7, 3, 0}, 2)

	fmt.Print(result)
}

func twoSum(nums []int, target int) [2]int {
	m := make(map[int]int)

	for i, v := range nums {
		complement := target - v
		containIndex, contains := m[complement]

		if contains {
			return [2]int{containIndex, i}
		}

		m[v] = i
	}

	return [2]int{0, 0}
}
