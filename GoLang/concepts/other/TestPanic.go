package main

import "fmt"

func main() {

	fmt.Println("Starting the program")
	panickingFunction()
	fmt.Println("Completing the program")
}

func panickingFunction() {
	fmt.Println("About to panic!")
	panic("Something went wrong!")
}
