package main

import "fmt"

func main() {
	//arr := make([]int, 3, 100)

	s := []int{}

	s = append(s, 6)

	fmt.Println("the value of s is ", s)

	s = append(s, 1, 2, 3, 4, 5)

	fmt.Println("the value of s is ", s)

	s = append(s, []int{10, 11, 12, 13}...)

	fmt.Println("the value of s is ", s)

	// Copying a slice
	copiedSlice := make([]int, len(s))
	copy(copiedSlice, s)
	fmt.Println("Copied slice:", copiedSlice)

	//modifying
	s[0] = 0
	fmt.Println("the value of s is ", s)

	//removing
	r := s[1:]         //beginning
	r1 := s[:len(s)-1] //end
	r2 := append(s[:2], s[3:]...)
	fmt.Println("the value of r is ", r)
	fmt.Println("the value of r1 is ", r1)
	fmt.Println("the value of r2 is ", r2)

}
