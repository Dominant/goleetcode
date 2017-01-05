// https://leetcode.com/problems/zigzag-conversion/
package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(convert("AB", 1))
	fmt.Println(convert("PAYPALISHIRING", 3))
	// I: PAYPALISHIRING
	// P   A   H   N
	// A P L S I I G
	// Y   I   R
	// ______________
	// O: PAHNAPLSIIGYIR

	fmt.Println(convert("DIGITALPERFORMANCEHIREDMASRURMIRBOBOEV", 4))
	// I: DIGITALPERFORMANCEHIREDMASRURMIRBOBOEV
	// D    L    R    H    A    I    E
	// I  A P  O M  E I  M S  M R  O V
	// G T  E F  A C  R D  R R  B B
	// I    R    N    E    U    O
	// ________________
	// O: DLRHAIEIAPOMEIMSMROVGTEFACRDRRBBIRNEUO
}

func convert(s string, numRows int) string {
	lenS, currRow, set, direction := len(s), 0, make([]string, numRows), 1

	for i := 0; i < lenS; i++ {
		set[currRow] += string(s[i])
		if currRow == numRows-1 {
			direction = -1
		}
		if currRow == 0 {
			direction = 1
		}
		currRow += direction
		if numRows == 1 {
			currRow = 0
		}
	}

	return strings.Join(set, "")
}
