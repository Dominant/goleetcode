// https://leetcode.com/problems/longest-substring-without-repeating-characters

package main

import "fmt"

func main() {
	fmt.Println(lengthOfLongestSubstring("c"))        // 1
	fmt.Println(lengthOfLongestSubstring("dvdf"))     // 3
	fmt.Println(lengthOfLongestSubstring("pwke"))     // 4
	fmt.Println(lengthOfLongestSubstring("pwwkezw"))  // 4
	fmt.Println(lengthOfLongestSubstring("jbpnbwwd")) // 4
}

func lengthOfLongestSubstring(s string) int {
	max, set := 0, make(map[string]int)

	for i := 0; i < len(s); i++ {
		char := string(s[i])

		if _, exists := set[char]; exists {
			if max < len(set) {
				max = len(set)
			}
			i = set[char]
			set = make(map[string]int)
			continue
		}

		set[char] = i
		if max < len(set) {
			max = len(set)
		}
	}

	return max
}
