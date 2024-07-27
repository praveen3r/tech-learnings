package main

import "fmt"

func main() {

	defer fmt.Println("Hello ")

	defer fmt.Println("World")

	defer fmt.Println("Praveen")

	fmt.Println("master")

}
