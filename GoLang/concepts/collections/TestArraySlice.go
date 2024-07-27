package main

import "fmt"

func main() {
	marks := []int{80, 90, 100}

	fmt.Println("the value of marks is ", marks[0])

	fmt.Println("the value of length is ", len(marks))

	arr := [5]int{1, 2, 3, 4, 5}
	s := arr[1:4] // slice from index 1 to 3 (excludes index 4)
	s1 := arr[1:] // slice from index 1
	s2 := arr[:2] // slice upto index 2
	s3 := arr[:]  // clone
	fmt.Println("the value of s is ", s)
	fmt.Println("the value of s1 is ", s1)
	fmt.Println("the value of s2 is ", s2)
	fmt.Println("the value of s3 is ", s3)
}
