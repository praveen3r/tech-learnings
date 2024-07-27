package main

import "fmt"

const a int = 12

const b = iota

const (
	c = iota
	d
	e
)

const (
	f = iota
)

const (
	_ = iota + 3
	g
)

func main() {

	const index int = 100
	fmt.Println("the value of index is ", index)
	fmt.Println("the value of c is ", c)
	fmt.Println("the value of d is ", d)
	fmt.Println("the value of e is ", e)
	fmt.Println("the value of f is ", f)

	const a int = 11

	fmt.Println("the value of a is ", a)

	fmt.Println("the value of b is ", b)

	fmt.Println("the value of g is ", g)

}
