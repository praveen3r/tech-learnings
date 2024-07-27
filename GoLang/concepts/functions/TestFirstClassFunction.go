package main

import "fmt"

type add func(a int, b int) int

func main() {

	/*first := func() {
		fmt.Println("Hello world")
	}

	first()*/

	func(str string) {
		fmt.Println("Hello world ", str)
	}("Praveen")

	var a add = func(a, b int) int {
		return a + b
	}

	s := a(1, 2)

	fmt.Println(s)

	f:= func (a, b int) int{
		return a+b
	}
	simple(f)

}

func simple(a func(a, b int) int){
	fmt.Println(a(5, 10))
}
