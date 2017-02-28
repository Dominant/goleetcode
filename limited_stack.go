// original - https://gist.github.com/moraes/2141121#gistcomment-1361598
package main

import "fmt"

type LimitedStack struct {
	Size  int
	nodes []string
}

func (s *LimitedStack) push(node string) *LimitedStack {
	s.nodes = append([]string{node}, s.nodes...)

	if len(s.nodes) > s.Size {
		s.nodes = s.nodes[0:s.Size]
	}

	return s
}

func (s *LimitedStack) pop() (node string) {
	x := len(s.nodes) - 1
	node = s.nodes[x]
	s.nodes = s.nodes[:x]
	return node
}

func main() {
	s := &LimitedStack{Size: 8}
	s.push("1").push("2").push("3").push("4").push("5")
	fmt.Printf("%+v\n", s)

	s.push("6").push("7").push("8").push("9").push("10")
	fmt.Printf("%+v\n", s)
}
