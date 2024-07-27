package main

import "fmt"

func main() {

	a := 10
	b := 20
	c := 50

	// if true {
	// 	fmt.Println("it is true")
	// }

	if a >= b {
		fmt.Println("A is bigger")
	}
	if a <= b {
		fmt.Println("B is bigger")
	}
	if a == b {
		fmt.Println("Both are equal")
	}

	if a < b && a < c {
		fmt.Println("A is small")
	}

	if a > b || a < c {
		fmt.Println("A is smallest")
	}

	if a != b {
		fmt.Println("A is not B")
	}

	if a == c {
		fmt.Println("A is equal to C")
	} else {
		fmt.Println("A is not equal to C")
	}
	

}
