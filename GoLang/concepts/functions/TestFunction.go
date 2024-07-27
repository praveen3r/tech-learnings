package main

import "fmt"

func main() {

	num1 := 20
	num2 := 30

	num3 := add(num1, num2)

	num4, num5 := multiReturn(num1, num2)

	fmt.Println("num3 is ", num3)

	fmt.Println("num4 is ", num4)

	fmt.Println("num5 is ", num5)
}

//func add(num1 int, num2 int) int {
func add(num1, num2 int) int {
	return num1 + num2

}

func multiReturn(num1, num2 int) (int, int) {
	return num1, num2

}
