package main

import "fmt"

var e int = 44

var overridingVar int = 20

func main() {
	var a int
	a = 1

	var b int = 12

	c := 22

	d := 33.

	var (
		testVar1 int = 50
		testVar2 int = 51
		testVar3 int = 52
	)

	var overridingVar int = 99

	//overridingVar = 100

	fmt.Println("the value of a is ", a)
	fmt.Println("the value of b is ", b)
	fmt.Println("the value of c is ", c)
	fmt.Println("the value of e is ", e)
	fmt.Println("the value of testVar1 is ", testVar1)
	fmt.Println("the value of testVar2 is ", testVar2)
	fmt.Println("the value of testVar3 is ", testVar3)
	fmt.Println("the value of overridingVar is ", overridingVar)

	fmt.Printf(" %T, %v", d, d)

}
