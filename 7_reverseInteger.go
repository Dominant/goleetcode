// https://leetcode.com/problems/reverse-integer/
package main

import "fmt"

func main() {
	fmt.Println(reverse(123))  // 321
	fmt.Println(reverse(-123)) // -321
	test2()
}

func reverse(x int) int {
	return x
}
