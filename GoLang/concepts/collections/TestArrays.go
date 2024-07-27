package main

import "fmt"

func main() {

	//marks := [3]int{80, 90, 100}

	marks := [...]int{80, 90, 100}

	var snames [3]string

	fmt.Println("the value of marks is ", marks[0])

	fmt.Println("the value of snames is ", snames)

	snames[0] = "Test1"
	snames[0] = "Test2"
	snames[0] = "Test3"

	fmt.Println("the value of snames is ", snames)

	fmt.Println("the value of length is ", len(snames))
}
