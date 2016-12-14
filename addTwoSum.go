package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	var l1 *ListNode = new(ListNode)
	var l2 *ListNode = new(ListNode)

	l1.Val = 5
	l2.Val = 5

	result := addTwoNumbers(l1, l2)
	fmt.Printf("%#v", result)
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var result *ListNode = new(ListNode)
	sumlist(l1, l2, result, 0)

	return result
}

func sumlist(l1 *ListNode, l2 *ListNode, r *ListNode, complement int) *ListNode {
	sum := l1.Val + l2.Val + complement
	complement = 0

	if sum >= 10 {
		sum, complement = sum-10, 1
	}

	r.Val = sum

	if l2.Next == nil && l1.Next != nil {
		l2.Next = new(ListNode)
	}

	if l1.Next == nil && l2.Next != nil {
		l1.Next = new(ListNode)
	}

	if l1.Next != nil && l2.Next != nil {
		r.Next = new(ListNode)
		sumlist(l1.Next, l2.Next, r.Next, complement)
	} else if complement != 0 {
		r.Next = new(ListNode)
		r.Next.Val = complement
	}

	return r
}
