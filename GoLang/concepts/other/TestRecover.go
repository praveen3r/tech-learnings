package main

import (
	"fmt"
	"runtime/debug"
)

func recoverFunc() {
	if r := recover(); r != nil {
		fmt.Println("Recovered from panic:", r)
		debug.PrintStack()
	}
}

func main() {

	fmt.Println("Starting the program")
	panickingFunction()
	fmt.Println("Completing the program")
}

func panickingFunction() {

	defer recoverFunc()
	fmt.Println("About to panic!")
	panic("Something went wrong!")
}
