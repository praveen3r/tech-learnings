package main

import "fmt"

func main() {
	fmt.Println("hello")

	var ptr *int

	fmt.Println("value of pointer is ", ptr)

	num := 30

	var myptr = &num

	fmt.Println("value of pointer is ", myptr)
	fmt.Println("value of pointer is ", *myptr)

	*myptr = *myptr + 2

	fmt.Println("value of num is ", num)

	fmt.Println("value of myptr is ", *myptr)

}
