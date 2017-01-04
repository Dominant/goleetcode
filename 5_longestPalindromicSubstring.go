// https://leetcode.com/problems/longest-palindromic-substring/
package main

import "fmt"

func main() {
	fmt.Println(longestPalindrome("babad")) // bab || aba
	fmt.Println(longestPalindrome("cbbd"))  // bb
}

func longestPalindrome(s string) string {
	maxPldS, lenS := "", len(s)

	for i := 0; i < lenS; i++ {
		for j := lenS; j > i; j-- {
			if isPalindrom(s[i:j]) && len(s[i:j]) > len(maxPldS) {
				maxPldS = s[i:j]
			}
			if len(maxPldS) == len(s)-i {
				return maxPldS
			}
		}
	}

	return maxPldS
}

func isPalindrom(s string) bool {
	isPalindrom := true
	sLen := len(s)

	for i := 0; i < sLen/2; i++ {
		if s[i] != s[sLen-i-1] {
			isPalindrom = false
			break
		}
	}

	return isPalindrom
}
