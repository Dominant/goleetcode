// https://leetcode.com/problems/reverse-integer/
package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(reverse(-7))   // -7
	fmt.Println(reverse(1))    // 1
	fmt.Println(reverse(10))   // 1
	fmt.Println(reverse(-10))  // -1
	fmt.Println(reverse(20))   // 2
	fmt.Println(reverse(50))   // 5
	fmt.Println(reverse(123))  // 321
	fmt.Println(reverse(-123)) // -321
}

func reverse(x int) int {
	if x < 10 && x > -10 {
		return x
	}

	negative := false

	if x < 0 {
		x = x * (-1)
		negative = true
	}

	reversed := 0

	for x >= 10 {
		reversed = (reversed * 10) + (x % 10)
		x = (int)(x / 10)
	}

	if x != 0 {
		reversed = reversed*10 + x
	}

	if reversed > math.MaxInt32 {
		reversed = 0
	}

	if negative {
		reversed *= -1
	}

	return reversed
}
