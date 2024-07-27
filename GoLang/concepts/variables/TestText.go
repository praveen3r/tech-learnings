package main

import "fmt"

func main() {

	var s string = "hello world"
	fmt.Println("the value of s is ", s)
	fmt.Println("the value of s[2] is ", s[2])
	fmt.Println("the value of string value of s[2] is ", string(s[2]))

	//concatenation
	var s1 string = "hello world"
	s2 := s1 + s
	fmt.Println("the value of s is ", s2)

}
